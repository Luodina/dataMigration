package com.example.demo.dao;

import com.example.demo.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssessmentDao extends JpaRepository<Assessment, Integer> {
    @Query( 
        //value = "select * from WK_ASSESSMENT aaa right JOIN (select * from (SELECT * from CIMS2STG.stg_for_cims2_intf t where t.data_domain ='ASMT' AND t.Process_status in 'TRANSFORMED' ORDER BY t.src_batch_id  ASC) where ROWNUM<=1) bbb on aaa.BATCH_ID=bbb.src_batch_id",
        value = "select * from WK_ASSESSMENT aaa right JOIN (select * from (SELECT * from CIMS2STG.stg_for_cims2_intf t where t.data_domain ='ASMT' AND t.Process_status in ('TRANSFORMED','ERR_APPLY') ORDER BY t.src_batch_id  ASC) where ROWNUM<=1) bbb on aaa.BATCH_ID=bbb.src_batch_id AND aaa.APPLY_STATUS is NULL or aaa.APPLY_STATUS ='ERROR'",
        nativeQuery = true)
    List<Assessment> getEverything();
}