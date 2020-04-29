package com.migration.assessment.daostaging;

import com.migration.assessment.entitystaging.JobControl;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.Date;
// import java.util.List;
// import java.util.Optional;
// import java.util.Map;
@Repository
//@Transactional
public interface JobControlDao extends JpaRepository<JobControl, String> {

    public JobControl findByModuleNameAndBatchName(@Param("moduleName") String moduleName, @Param("batchName") String batchName);  
   
    // @Procedure(procedureName = "PKG_JOB_CONTROL.SP_JOB_START", outputParameterName = "OUT_INSTANCE_ID")
    // public Integer jobStart(
    //     @Param("IN_MODULE_NAME") String IN_MODULE_NAME, 
    //     @Param("IN_BATCH_NAME") String IN_BATCH_NAME, 
    //     @Param("IN_INST_CD") String IN_INST_CD,
    //     @Param("IN_APPLICATION_CD") String IN_APPLICATION_CD,
    //     @Param("IN_JOB_TYPE") String IN_JOB_TYPE,
    //     @Param("IN_DATA_FROM_DTM") String IN_DATA_FROM_DTM,
    //     @Param("IN_DATA_TO_DTM") String IN_DATA_TO_DTM,
    //     @Param("IN_PROCESS_ID") Integer IN_PROCESS_ID,
    //     @Param("OUT_RESULT_CD") int OUT_RESULT_CD,
    //     @Param("OUT_RESULT_MSG") String OUT_RESULT_MSG
    //     );

    @Procedure(name = "PKG_JOB_CONTROL.SP_JOB_START") 
    public Object jobStart(
            @Param("IN_MODULE_NAME") String IN_MODULE_NAME, 
            @Param("IN_BATCH_NAME") String IN_BATCH_NAME, 
            @Param("IN_INST_CD") String IN_INST_CD,
            @Param("IN_APPLICATION_CD") String IN_APPLICATION_CD,
            @Param("IN_JOB_TYPE") String IN_JOB_TYPE,
            @Param("IN_DATA_FROM_DTM") String IN_DATA_FROM_DTM,
            @Param("IN_DATA_TO_DTM") String IN_DATA_TO_DTM,
            @Param("IN_PROCESS_ID") Integer IN_PROCESS_ID
            // ,
            // @Param("OUT_RESULT_CD") String OUT_RESULT_CD,
            // @Param("OUT_RESULT_MSG") String OUT_RESULT_MSG,
            // @Param("OUT_INSTANCE_ID") Integer OUT_INSTANCE_ID
            );

    @Procedure(procedureName = "PKG_JOB_CONTROL.SP_JOB_UPDATE", outputParameterName = "OUT_RESULT_MSG")
    public String jobUpdate(
        @Param("IN_MODULE_NAME") String IN_MODULE_NAME, 
        @Param("IN_BATCH_NAME") String IN_BATCH_NAME, 
        @Param("IN_INST_CD") String IN_INST_CD,
        @Param("IN_APPLICATION_CD") String IN_APPLICATION_CD,
        @Param("IN_JOB_TYPE") String IN_JOB_TYPE,
        @Param("IN_CURRENT_STEP") String IN_CURRENT_STEP,
        @Param("IN_INSTANCE_ID") Integer IN_INSTANCE_ID,
        @Param("IN_COMMIT_DTM") String IN_COMMIT_DTM,
        @Param("IN_DATA_DTM") String IN_DATA_DTM,
        @Param("OUT_RESULT_CD") int OUT_RESULT_CD
        );

}