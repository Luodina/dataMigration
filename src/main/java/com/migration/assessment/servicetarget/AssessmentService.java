package com.migration.assessment.servicetarget;

import com.migration.assessment.daotarget.AssessmentDao;
import com.migration.assessment.entitytarget.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class AssessmentService {
    private static Logger log = LoggerFactory.getLogger(AssessmentService.class);
    
    @Autowired
    AssessmentDao assessmentDao;

    // public List<Assessment> getAssessmentList() {
    //     return this.assessmentDao.getEverything();
    // }
    public List<Assessment> getAssessmentList() {
        return this.assessmentDao.findAll();
    }

    // public Assessment getAssessmentListById(Long id) {
    //     return this.AssessmentDao.findById(id).get();
    // }

    @Transactional(readOnly = false)
    public String updateAssessment(Assessment asmt) {
        try{
            Assessment ff = this.assessmentDao.saveAndFlush(asmt);
            System.out.println(ff);
            return "APPLIED";
        } catch(Exception e) {
            log.info(e.getMessage());
            return "ERROR";
        }     
    }
    
}