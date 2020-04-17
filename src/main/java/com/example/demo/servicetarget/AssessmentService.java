package com.example.demo.servicetarget;

import com.example.demo.daotarget.AssessmentDao;
import com.example.demo.entitytarget.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class AssessmentService {

    private static Logger log = LoggerFactory.getLogger(AssessmentService.class);

    @Autowired
    AssessmentDao AssessmentDao;

    public List<Assessment> getAssessmentList() {
        return this.AssessmentDao.getEverything();
    }

    // public Assessment getAssessmentListById(Long id) {
    //     return this.AssessmentDao.findById(id).get();
    // }

    // @Transactional(readOnly = false)
    // public String saveAssessment(Assessment asmt) {
    //     try{
    //         Assessment ff = this.AssessmentDao.saveAndFlush(asmt);
    //         System.out.println(ff);
    //         return "SUCCESSS!!!";
    //     } catch(Exception e) {
    //         log.info(e.getMessage());
    //         return "ERROR!!!";
    //     }     
    // }
    
}