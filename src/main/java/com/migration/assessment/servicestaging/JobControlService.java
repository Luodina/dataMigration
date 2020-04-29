package com.migration.assessment.servicestaging;

import java.util.List;
import java.util.Map;

import com.migration.assessment.daostaging.JobControlDao;
import com.migration.assessment.entitystaging.JobControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Map;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@Service
public class JobControlService {
    // private static Logger log = LoggerFactory.getLogger(WKAssessmentService.class);
    @Autowired
    JobControlDao jobControlDao;

    public JobControl getJobControlByModuleNmAndBatchNm(String moduleName, String batchName) {
        return this.jobControlDao.findByModuleNameAndBatchName(moduleName, batchName);
    }

    // public List<JobControl> getJobControlList() {
    //     return this.jobControlDao.findAll();
    // }

    public Integer jobStart(
        String IN_MODULE_NAME, 
        String IN_BATCH_NAME, 
        String IN_INST_CD,
        String IN_APPLICATION_CD, 
        String IN_JOB_TYPE, 
        String IN_DATA_FROM_DTM, 
        String IN_DATA_TO_DTM, 
        Integer IN_PROCESS_ID//,
        // String OUT_RESULT_CD,
        // String OUT_RESULT_MSG,
        // Integer OUT_INSTANCE_ID
        ){    
            System.out.println("instId "+
            IN_MODULE_NAME+" ,"+
            IN_BATCH_NAME+" ,"+
            IN_INST_CD+" ,"+
            IN_APPLICATION_CD+" ,"+
            IN_JOB_TYPE+" ,"+
            IN_DATA_FROM_DTM+" ,"+
            IN_DATA_TO_DTM+" ,"+
            IN_PROCESS_ID+" ");   
            
            Object instId= this.jobControlDao.jobStart(//"ASMT","DH_HA_DATA_APPLY","ALL" ,"DATASYNC" ,"N" ,"2020-04-09 08:34:49.414362" ,"2020-04-15 12:40:34.544023",0);
                IN_MODULE_NAME, 
                IN_BATCH_NAME, 
                IN_INST_CD,
                IN_APPLICATION_CD, 
                IN_JOB_TYPE, 
                IN_DATA_FROM_DTM, 
                IN_DATA_TO_DTM, 
                IN_PROCESS_ID
                );
                System.out.println("instId"+instId);
            //return instId;
            return 2345;
    }

    public String jobUpdate(
        String IN_MODULE_NAME, 
        String IN_BATCH_NAME, 
        String IN_INST_CD,
        String IN_APPLICATION_CD, 
        String IN_JOB_TYPE, 
        String IN_CURRENT_STEP,
        Integer IN_INSTANCE_ID,
        String IN_COMMIT_DTM,
        String IN_DATA_DTM,
        int OUT_RESULT_CD
        ){   
            String instId= this.jobControlDao.jobUpdate(
                IN_MODULE_NAME, 
                IN_BATCH_NAME, 
                IN_INST_CD,
                IN_APPLICATION_CD, 
                IN_JOB_TYPE, 
                IN_CURRENT_STEP,
                IN_INSTANCE_ID,
                IN_COMMIT_DTM,
                IN_DATA_DTM,
                OUT_RESULT_CD
            );
            return instId;
    }
}