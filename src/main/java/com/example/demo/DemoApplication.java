package com.example.demo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.entitytarget.Assessment;
import com.example.demo.entitystaging.WKAssessment;
import com.example.demo.servicestaging.WKAssessmentService;
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
			LocalDateTime date = LocalDateTime.now();
			System.out.println("222222");
			List<WKAssessment> bbb = wkAssessmentService.getAssessmentList();	
			WKAssessment first = bbb.get(3);
			System.out.println("************** ASMT from STAGING");
			System.out.println(first);

			// List<Assessment> aaa = assessmentService.getAssessmentList();	
			// Assessment second = aaa.get(0);
			// System.out.println("************** ASMT from TARGET");
			// System.out.println(second);
			Assessment migAssessment = new Assessment();
			migAssessment.setAssessmentId(first.getAssessmentId());
			migAssessment.setEncounterId(first.getAssessmentId());
			migAssessment.setClinicCd(first.getClinicCd());
			migAssessment.setCodeAssessmentCd(first.getCodeAssessmentCd());
			migAssessment.setCodeAssessmentFieldId(first.getCodeAssessmentFieldId());
			migAssessment.setRowId(first.getRowId());
			migAssessment.setAssessmentResult(first.getAssessmentResult());
			migAssessment.setCims1Key(first.getCims1Key());
			migAssessment.setCreatedBy(first.getCreatedBy());
			migAssessment.setCreatedDTM(first.getCreatedDTM());
			migAssessment.setUpdatedBy(first.getUpdatedBy());
			migAssessment.setUpdatedDTM(new Timestamp(System.currentTimeMillis()));
			migAssessment.setVersion(first.getVersion());
			System.out.println("############################ MIG ASMT");
			System.out.println(migAssessment);
			String result = assessmentService.updateAssessment(migAssessment);
			System.out.println("############################ RESULT updateAssessment TARGET");
			System.out.println(result);
			first.setApplyStatus(result);	
			first.setApplyDTM(date);	
			String res = wkAssessmentService.updateWKAssessment(first);
			System.out.println("############################ RESULT updateAssessment STAGING");
			System.out.println(res);  
			// log.info(statusUpd);
		}

	}
		
}
