package com.migration.assessment.servicetarget;

import com.migration.assessment.daotarget.LogAssessmentDao;
import com.migration.assessment.entitytarget.LogAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LogAssessmentService {
    private static Logger log = LoggerFactory.getLogger(AssessmentService.class);
    
    @Autowired
    LogAssessmentDao logAssessmentDao;

    @Transactional(readOnly = false)
    public String updateLogAssessment(LogAssessment logAsmt) {
        try{
            LogAssessment ff = this.logAssessmentDao.saveAndFlush(logAsmt);
            System.out.println(ff);
            return "APPLIED";
        } catch(Exception e) {
            log.info(e.getMessage());
            return "ERROR";
        }     
    }
    
}