package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Assessment;

@RestController
public class ConsumeWebService {
   @Autowired
   RestTemplate restTemplate;

    //@RequestMapping(value = "/template/products")
    public String getAssessmentList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(
            "https://cims-assessment-svc-cims-dh-cims-dev-1.cldpaast71.server.ha.org.hk/assessment/20200407001036/KFC/FCS", HttpMethod.GET, entity, String.class).getBody();
    }

    //@RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createAssessment(Assessment assessment) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //Assessment assessment =new Assessment();
        System.out.println(assessment.toString());
    

        HttpEntity<Assessment> entity = new HttpEntity<Assessment>(assessment, headers);
        
        return restTemplate.exchange(
            "https://cims-assessment-svc-cims-dh-cims-dev-1.cldpaast71.server.ha.org.hk/assessment/", HttpMethod.POST, entity, String.class).getBody();
    }
   
}