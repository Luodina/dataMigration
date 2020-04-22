package com.example.demo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.entitytarget.Assessment;
import com.example.demo.entitystaging.WKAssessment;
import com.example.demo.entitystaging.JobControl;
import com.example.demo.servicestaging.WKAssessmentService;
import com.example.demo.servicestaging.JobControlService;
import com.example.demo.servicetarget.AssessmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	AssessmentService assessmentService;

	@Autowired
	WKAssessmentService wkAssessmentService;

	@Autowired
	JobControlService jobControlService;
	public static void main(final String[] args) throws Exception  {
		log.info("start");
		SpringApplication.run(DemoApplication.class, args);	
		log.info("finish");	
	}
	
	// @Bean
	// 	public RestTemplate getRestTemplate() {
	// 	   return new RestTemplate();       
	// 	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
			System.out.println("111111");
		} else {
			//get JobControl data
			JobControl jc=jobControlService.getJobControlByModuleNmAndBatchNm("ASMT","DH_HA_DATA_APPLY");
			System.out.println("========JobControl========" + jc.getModuleName()+ "   "+jc.getBatchName());
			Integer instId = jobControlService.jobStart(
				jc.getModuleName(),
				jc.getBatchName(),
				jc.getInstCd(),
				jc.getApplicationCd(),
				jc.getJobType(),
				jc.getDataFromDTM(),
				jc.getDataToDTM(),
				0,0,""
			);

			if (instId != null){
				System.out.println("=========Inst Id======="+instId);	
				String resMsg= this.jobControlService.jobUpdate(
					jc.getModuleName(), 
					jc.getBatchName(), 
					jc.getInstCd(),
					jc.getApplicationCd(),
					jc.getJobType(),
					jc.getCurrentStep(),
					instId,
					jc.getCommitDataDTM(),
					jc.getDataDTM(),
					0
				);	
				System.out.println(resMsg);	
			}	
			LocalDateTime date = LocalDateTime.now();
			List<WKAssessment> wkAsmtList = wkAssessmentService.getAssessmentList();
			System.out.println("************** wkAsmtList " +wkAsmtList);
			System.out.println("************** wkAsmtList.size " + wkAsmtList.size());
			if (wkAsmtList.size()>1){				
				for(WKAssessment wkAsmt : wkAsmtList) {
				System.out.println("*********** wkAsmt" + wkAsmt);
				Assessment migAssessment = new Assessment();
				migAssessment.setAssessmentId(wkAsmt.getAssessmentId());
				migAssessment.setEncounterId(wkAsmt.getAssessmentId());
				migAssessment.setClinicCd(wkAsmt.getClinicCd());
				migAssessment.setCodeAssessmentCd(wkAsmt.getCodeAssessmentCd());
				migAssessment.setCodeAssessmentFieldId(wkAsmt.getCodeAssessmentFieldId());
				migAssessment.setRowId(wkAsmt.getRowId());
				migAssessment.setAssessmentResult("migrated");//(wkAsmt.getAssessmentResult());
				migAssessment.setCims1Key(wkAsmt.getCims1Key());
				migAssessment.setCreatedBy(wkAsmt.getCreatedBy());
				migAssessment.setCreatedDTM(wkAsmt.getCreatedDTM());
				migAssessment.setUpdatedBy(wkAsmt.getUpdatedBy());
				migAssessment.setUpdatedDTM(new Timestamp(System.currentTimeMillis()));
				migAssessment.setVersion(wkAsmt.getVersion());
				//System.out.println("*********** migAssessment" + migAssessment);
				String targetRes = assessmentService.updateAssessment(migAssessment);
				System.out.println("*********** RESULT updateAssessment TARGET" + targetRes);
				wkAsmt.setApplyStatus(targetRes);	
				wkAsmt.setApplyDTM(date);	
				String stagingRes = wkAssessmentService.updateWKAssessment(wkAsmt);
				System.out.println("*********** RESULT updateAssessment STAGING"+stagingRes);
			}
			}
		}

	}
		
}
