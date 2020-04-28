package com.migration.assessment.servicestaging;

import com.migration.assessment.daostaging.WKAssessmentDao;
import com.migration.assessment.entitystaging.WKAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.time.LocalDateTime;
import java.util.List;


//@Transactional
@Service
public class WKAssessmentService {

    private static Logger log = LoggerFactory.getLogger(WKAssessmentService.class);
    @Autowired
    WKAssessmentDao wkAssessmentDao;

    public List<WKAssessment> getAssessmentList() {
        return this.wkAssessmentDao.getEverything();
    }

    public WKAssessment getAssessmentListById(Long id) {
        return this.wkAssessmentDao.getAssessmentListById(id);
    }
    
    @Transactional(readOnly = false)
    public String updateWKAssessment(WKAssessment asmt) {
        try{
            WKAssessment ff = this.wkAssessmentDao.saveAndFlush(asmt);
            System.out.println(ff);
            return "SUCCESSS";
        } catch(Exception e) {
            log.info(e.getMessage());
            return "ERROR";
        }        
    }
}