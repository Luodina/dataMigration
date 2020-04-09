package com.example.demo.controller;

import com.example.demo.entity.StgForCims2Intf;
import com.example.demo.service.StgForCims2IntfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xxx")
public class StgForCims2IntfController {
    @Autowired
    StgForCims2IntfService stgForCims2IntfService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    // public List<Assessment> getAllAssessments() {
    //     return this.assessmentService.getAllAssessments();
    // }
    @Query("SELECT * from stg_for_cims2_intf where data_domain ='ASMT'")
    public List<StgForCims2Intf> getAllStg_for_cims2_intf() {
        return this.stgForCims2IntfService.getAllStgForCims2Intf();
    }

}