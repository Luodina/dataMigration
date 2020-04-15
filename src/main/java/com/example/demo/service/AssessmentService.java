package com.example.demo.service;

import com.example.demo.dao.AssessmentDao;
import com.example.demo.entity.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource;
// import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
//import java.util.Optional;

@Service
public class AssessmentService {
    @Autowired
    AssessmentDao assessmentDao;

    public List<Assessment> getAssessmentList() {
        return this.assessmentDao.getEverything();
    }

    public Assessment getAssessmentListById(Long id) {
        return this.assessmentDao.getAssessmentListById(id);
    }
    
    @Transactional
    public int updateApplyStatus(Long id, String status) {

        System.out.println("************** id");
        System.out.println(id);
        System.out.println("************** status");
        System.out.println(status);
        return this.assessmentDao.updateApply();
    }
}