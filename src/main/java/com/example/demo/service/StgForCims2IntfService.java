package com.example.demo.service;

import com.example.demo.dao.StgForCims2IntfDao;
import com.example.demo.entity.StgForCims2Intf;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource;
// import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StgForCims2IntfService {
    @Autowired
    StgForCims2IntfDao stgForCims2IntfDao;

    public List<StgForCims2Intf> getAllStgForCims2Intf() {
        return this.stgForCims2IntfDao.getEverything();
    }
}