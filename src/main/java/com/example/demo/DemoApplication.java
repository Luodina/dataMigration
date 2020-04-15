package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

//import com.example.demo.controller.AssessmentController;

//import java.util.List;

import com.example.demo.controller.ConsumeWebService;
import com.example.demo.entity.Assessment;
//import com.example.demo.entity.Assessment;
import com.example.demo.service.AssessmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import static java.lang.System.exit;

@EnableTransactionManagement
@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	@Autowired
	ConsumeWebService consumeWebService;

	@Autowired
	AssessmentService assessmentService;
	public static void main(final String[] args) throws Exception  {
		log.info("start");
		SpringApplication.run(DemoApplication.class, args);	
		log.info("finish");
		
	}
	
	@Bean
		public RestTemplate getRestTemplate() {
		   return new RestTemplate();
		}
	
	// Put your logic here.
	@Override
	public void run(String... args) throws Exception {
		if (args.length > 0) {
			System.out.println("111111");
		} else {
			List<Assessment> bbb = assessmentService.getAssessmentList();	
			Assessment first = bbb.get(0);
			System.out.println("@@@@@@@@@@@@@@@");
			System.out.println(first.toString());
			// for (Assessment aName : bbb) {
			// 	System.out.println(aName.toString());
			// }
			// System.out.println(bbb);
			//log.info(bbb);
			Boolean postRes = consumeWebService.createAssessment(first);
			System.out.println("**************");
			System.out.println(first);
			System.out.println(postRes.toString());
			int statusUpd ;
			if (postRes) {
				System.out.println("APPLIED");
				Assessment ccc = assessmentService.getAssessmentListById(first.getId());	
				ccc.setApplyStatus("APPLIED");	
				System.out.println(ccc);
				
				
				// statusUpd= assessmentService.updateApplyStatus(first.getId(),"APPLIED!!");
				// System.out.println(statusUpd);
			  } else {
				System.out.println("ERROR");
				//statusUpd= assessmentService.updateApplyStatus(first.getId(),"ERROR");	
			  }
			//log.info(statusUpd.toString());
		}

	}
		
}
