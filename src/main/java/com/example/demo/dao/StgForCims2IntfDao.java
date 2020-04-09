package com.example.demo.dao;

import com.example.demo.entity.StgForCims2Intf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StgForCims2IntfDao  extends JpaRepository<StgForCims2Intf, Integer>  {
    
    @Query( value = "select * from (SELECT * from CIMS2STG.stg_for_cims2_intf t where t.data_domain ='ASMT' AND t.Process_status ='TRANSFORMED' ORDER BY t.src_batch_id  ASC) where ROWNUM<=1", 
            nativeQuery = true)
    List<StgForCims2Intf> getEverything();

}