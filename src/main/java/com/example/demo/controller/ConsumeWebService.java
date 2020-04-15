package com.example.demo.controller;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        String theUrl = "https://cims-assessment-svc-cims-dh-cims-dev-1.cldpaast71.server.ha.org.hk/assessment/";
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class).getBody();
    }

    //@RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public Boolean createAssessment(Assessment assessment) {
        String authToken = "eyJhbGciOiJSUzI1NiJ9.eyJsb2dpbl9uYW1lIjoiRkNTX0RSIiwidXNlcl9pZCI6Ijk0IiwiY2xpbmljX2NkIjoiS0ZDIiwic2VydmljZV9jZCI6IkZDUyIsImFjY2Vzc1JpZ2h0SWRzIjpbIkYwMjIiLCJGMDE5IiwiRjA1MiIsIkYxMjEiLCJGMDkxIiwiRjAzMiIsIkYwMjMiLCJGMTA3IiwiRjAzMyIsIkYwMDEiLCJGMTE4IiwiRjIwMSIsIkYxMjIiLCJCMDA0IiwiRjAyMSIsIkYwMDciLCJGMDI4IiwiRjA5MCIsIkYwMTAiLCJGMTA0IiwiRjAwNiIsIkYwMjUiLCJGMjAwIiwiRjEwMSIsIkYxMTIiLCJGMDQ5IiwiRjAzNSIsIkYxMTUiLCJGMDE4IiwiRjEwNiIsIkYwNTEiLCJGMTE0IiwiRjA0OCIsIkYwMDQiLCJGMDE2IiwiRjExMSIsIkYxMDUiLCJCMDAxIiwiRjAxMyIsIkYwMjQiLCJGMDI2IiwiRjAxNSIsIkYwMzAiLCJGMDA1IiwiRjEwMyIsIkYwNDYiLCJCMTUwIiwiRjAzMSIsIkYwNDMiLCJGMDQ3IiwiRjExNyIsIkYwMjkiLCJGMDAzIiwiRjExMyIsIkYwNDUiLCJGMDExIiwiRjAxNCIsIkYxMTkiLCJGMDEyIiwiRjAzNCIsIkYyMDMiLCJGMDI3IiwiRjA5MyIsIkIwMDMiLCJGMDA5IiwiRjExNiIsIkYwOTIiLCJGMDA4IiwiQjAwMiIsIkYwMTciLCJGMjA0IiwiRjAyMCIsIkYyMDUiLCJGMjAyIiwiRjEwMiIsIkYwMDIiLCJGMDUwIl0sInN1YiI6Ijk0IiwiaWF0IjoxNTg2OTE3Njg5LCJleHAiOjE1ODY5MTk0ODl9.LeRL99Fj_9aoOWoGxrlK4Rmwiw6X4l6fOIKF3XbD4VsA3ALIXIQE2E4KkQU3XfhDpQmhMq1PbbxTsTvSELXrJWDbCmcDLBszEaSlfI7qrfB9cv7sYB27vYqh6GBiV08UBKGDCrJ0yqPlv21kVipJrZkcfIPviv8FuoqkQXLUDcB7qkHeDKeeBCb_ge8fZ9U8CxgRWewxtsTGwdvzpUrrJucmbo_M00ibz39mzbkBbItQAXYEcxbLbSF5_AY9B2xNvaX0ZRuRmReg4GO5vMkHDKiE6Hmo3XK8vU67cRCiKy4ROzJ2lJDXltouYEY76YZeTKFhSiXLonnDVHopvDhCLw";
        String theUrl = "https://cims-assessment-svc-cims-dh-cims-dev-1.cldpaast71.server.ha.org.hk/assessment/";
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("User-Agent", "Spring's RestTemplate" ); 
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer "+authToken);

        //Assessment assessment =new Assessment();
        System.out.println(assessment.toString());
        // Prepare values for fieldValueDtos
        JSONArray createdBys = new JSONArray();
        JSONArray createdDtms = new JSONArray();
        JSONArray assessmentResults = new JSONArray();
        createdBys.put(0, JSONObject.NULL);
        createdDtms.put(0, JSONObject.NULL);
        assessmentResults.put(0, assessment.getAssessmentResult());

        // Setup fieldValueDtos
        JSONArray fieldValueDtos = new JSONArray();
        JSONObject fieldValueDtosObject = new JSONObject();
        fieldValueDtosObject.put("codeAssessmentFieldId", assessment.getCodeAssessmentFieldId());
        fieldValueDtosObject.put("dataType", "DOUBLE");
        fieldValueDtosObject.put("createdBys", createdBys);
        fieldValueDtosObject.put("createdDtms", createdDtms);
        fieldValueDtosObject.put("assessmentResults", assessmentResults);
        fieldValueDtos.put(0, fieldValueDtosObject);

        // Setup assessmentValueDtos
        JSONObject assessmentValueDtosObject = new JSONObject();
        assessmentValueDtosObject.put("codeAssessmentCd", assessment.getCodeAssessmentCd());
        assessmentValueDtosObject.put("fieldValueDtos", fieldValueDtos);
        JSONArray assessmentValueDtos = new JSONArray();
        assessmentValueDtos.put(0, assessmentValueDtosObject);

        // Setup final JSON input
        JSONObject finalInput = new JSONObject();
        finalInput.put("clinicCd", assessment.getClinicCd());
        finalInput.put("serviceCd", "FCS");
        finalInput.put("cimsKey", assessment.getAssessmentId());
        finalInput.put("assessmentValueDtos", assessmentValueDtos);
        finalInput.put("encounterId", assessment.getEncounterId());
        System.out.println(finalInput.toString());
        HttpEntity<String> entity = new HttpEntity<String>(finalInput.toString(), headers);
        // ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(theUrl, HttpMethod.POST, entity, JSONObject.class);
        // String a= responseEntity.getBody().();
        // String jsonString = JSON.toJSONString(list);
        // List<String> data =JSON.parseArray(jsonString, String.class);
        // System.out.println(data);
        // return "fff";
        // System.out.println("#########");
        ResponseEntity<String> responseEntity = restTemplate.exchange(theUrl, HttpMethod.POST, entity, String.class);
        System.out.println(responseEntity);
        System.out.println("#########");
        System.out.println(responseEntity.getStatusCode().is2xxSuccessful());
        Boolean resp = responseEntity.getStatusCode().is2xxSuccessful();
        System.out.println("#########");
        //String aaa = responseEntity.getBody();
        System.out.println("######### msgCode");       
        return resp;
    }
   
}