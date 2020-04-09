package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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
			System.out.println("222222");
			List<Assessment> bbb = assessmentService.xxx();	
			Assessment first = bbb.get(0);
			System.out.println("@@@@@@@@@@@@@");
			System.out.println(first.toString());
			// for (Assessment aName : bbb) {
			// 	System.out.println(aName.toString());
			// }
			//System.out.println(bbb);
			//log.info(bbb);
			String aaa = consumeWebService.createAssessment(first);
			log.info(aaa);
		}

	}
		
}
