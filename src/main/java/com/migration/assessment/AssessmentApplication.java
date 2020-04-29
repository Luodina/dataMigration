package com.migration.assessment;

import java.sql.Timestamp;
import java.util.List;
import com.migration.assessment.entitytarget.Assessment;
import com.migration.assessment.entitytarget.LogAssessment;
import com.migration.assessment.entitystaging.WKAssessment;
import com.migration.assessment.entitystaging.JobControl;
import com.migration.assessment.servicestaging.WKAssessmentService;
import com.migration.assessment.servicestaging.JobControlService;
import com.migration.assessment.servicetarget.AssessmentService;
import com.migration.assessment.servicetarget.LogAssessmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssessmentApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(AssessmentApplication.class);

	@Autowired
	AssessmentService assessmentService;

	@Autowired
	WKAssessmentService wkAssessmentService;

	@Autowired
	LogAssessmentService logAssessmentService;
	
	@Autowired
	JobControlService jobControlService;
	public static void main(final String[] args) throws Exception  {
		log.info("start");
		SpringApplication.run(AssessmentApplication.class, args);	
		log.info("finish");	
	}
	
	// @Bean
	// 	public RestTemplate getRestTemplate() {
	// 	   return new RestTemplate();       
	// 	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
			//System.out.println("111111");
		} else {
			//get JobControl data
			JobControl jc=jobControlService.getJobControlByModuleNmAndBatchNm("ASMT","DH_HA_DATA_APPLY");
			//jobStart	
			Integer instId = jobControlService.jobStart(
				jc.getModuleName(),
				jc.getBatchName(),
				jc.getInstCd(),
				jc.getApplicationCd(),
				jc.getJobType(),
				jc.getDataFromDTM(),
				jc.getDataToDTM(),
				0
				//,"","",0
			);
			System.out.println("instId"+instId);
		// 	if (instId != null){	
		// 		List<WKAssessment> wkAsmtList = wkAssessmentService.getAssessmentList();
		// 		System.out.println("************** wkAsmtList SIZE " +wkAsmtList.size());
		// 		if (wkAsmtList.size()>0 && wkAsmtList.get(0)!= null){				
		// 			for(WKAssessment wkAsmt : wkAsmtList) {
		// 				//update Assessment
		// 				// System.out.println("*********** wkAsmt" + wkAsmt);
		// 				Assessment migAssessment = new Assessment();
		// 				migAssessment.setAssessmentId(wkAsmt.getAssessmentId());
		// 				migAssessment.setEncounterId(wkAsmt.getEncounterId());
		// 				migAssessment.setClinicCd(wkAsmt.getClinicCd());
		// 				migAssessment.setCodeAssessmentCd(wkAsmt.getCodeAssessmentCd());
		// 				migAssessment.setCodeAssessmentFieldId(wkAsmt.getCodeAssessmentFieldId());
		// 				migAssessment.setRowId(wkAsmt.getRowId());
		// 				migAssessment.setAssessmentResult(wkAsmt.getAssessmentResult());
		// 				migAssessment.setCims1Key(wkAsmt.getCims1Key());
		// 				migAssessment.setCreatedBy(wkAsmt.getCreatedBy());
		// 				migAssessment.setCreatedDTM(wkAsmt.getCreatedDTM());
		// 				migAssessment.setUpdatedBy(wkAsmt.getUpdatedBy());
		// 				migAssessment.setUpdatedDTM(new Timestamp(System.currentTimeMillis()));
		// 				migAssessment.setVersion(wkAsmt.getVersion());
		// 				String targetRes = assessmentService.updateAssessment(migAssessment);
		// 				System.out.println("*********** RESULT ASSESSMENT " + targetRes);
		// 				//update Log Assessment
		// 				LogAssessment logAssessment = new LogAssessment();
		// 				logAssessment.setAssessmentId(wkAsmt.getAssessmentId());
		// 				logAssessment.setEncounterId(wkAsmt.getEncounterId());
		// 				logAssessment.setClinicCd(wkAsmt.getClinicCd());
		// 				logAssessment.setCodeAssessmentCd(wkAsmt.getCodeAssessmentCd());
		// 				logAssessment.setCodeAssessmentFieldId(wkAsmt.getCodeAssessmentFieldId());
		// 				logAssessment.setAssessmentResult(wkAsmt.getAssessmentResult());
		// 				logAssessment.setRowId(wkAsmt.getRowId());
		// 				logAssessment.setCims1Key(wkAsmt.getAssessmentId());
		// 				logAssessment.setCreatedBy(wkAsmt.getCreatedBy());
		// 				logAssessment.setCreatedDTM(wkAsmt.getCreatedDTM()); 
		// 				logAssessment.setUpdatedBy(wkAsmt.getUpdatedBy()); 
		// 				logAssessment.setUpdatedDTM(wkAsmt.getUpdatedDTM()); 
		// 				logAssessment.setCreatedBy(wkAsmt.getCreatedBy());
		// 				logAssessment.setLogCreatedDTM(new Timestamp(System.currentTimeMillis()));
		// 				logAssessment.setLogType("I");
		// 				String logTargetRes = logAssessmentService.updateLogAssessment(logAssessment);
		// 				System.out.println("*********** RESULT LOG ASSESSMENT:  " + logTargetRes);
		// 				//update status in wk_asmt
		// 				wkAsmt.setApplyStatus(targetRes);	
		// 				wkAsmt.setApplyDTM(new Timestamp(System.currentTimeMillis()));	
		// 				String stagingRes = wkAssessmentService.updateWKAssessment(wkAsmt);
		// 				System.out.println("*********** RESULT WK_ASSESSMENT "+stagingRes);
		// 			}
		// 		} 
		// 		// System.out.println("=========Inst Id======="+instId);
		// 		// jobUpdate	
		// 		String resMsg= this.jobControlService.jobUpdate(
		// 			jc.getModuleName(), 
		// 			jc.getBatchName(), 
		// 			jc.getInstCd(),
		// 			jc.getApplicationCd(),
		// 			jc.getJobType(),
		// 			jc.getCurrentStep(),
		// 			instId,
		// 			jc.getCommitDataDTM(),
		// 			jc.getDataDTM(),
		// 			0
		// 		);	
		// 		System.out.println(resMsg);	
		// 	}
	}
	}
		
}
