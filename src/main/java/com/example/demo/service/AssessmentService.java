package com.example.demo.service;

import com.example.demo.dao.AssessmentDao;
import com.example.demo.entity.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource;
// import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class AssessmentService {
    @Autowired
    AssessmentDao assessmentDao;

    public List<Assessment> xxx() {
        return this.assessmentDao.getEverything();
    }
    // public List<Assessment> getAllAssessments() {
    //     return this.assessmentDao.findAll();
    // }

    // public Assessment addAssessment(Assessment assessment) {
    //     return this.assessmentDao.save(assessment);
    // }

    // //other methods go here


    // public Optional<Assessment> getAssessmentById(int id) {
    //     return this.assessmentDao.findById(id);
    // }

    // public Assessment updateAssessment(Assessment assessment) {
    //     return this.assessmentDao.save(assessment);
    // }

    // public void deleteAssessmentById(int id) {
    //     this.assessmentDao.deleteById(id);
    // }

    // public void deleteAllAssessments() {
    //     this.assessmentDao.deleteAll();
    // }


}