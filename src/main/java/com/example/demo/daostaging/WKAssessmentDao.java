package com.example.demo.daostaging;

import com.example.demo.entitystaging.WKAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
//@Transactional
public interface WKAssessmentDao extends JpaRepository<WKAssessment, Long> {
    @Query(value = "select * from WK_ASSESSMENT aaa right JOIN (select * from (SELECT * " +
            "from stg_for_cims2_intf t where t.data_domain ='ASMT' AND t.Process_status in "+
            "('TRANSFORMED','ERR_APPLY') ORDER BY t.src_batch_id ASC) where ROWNUM<=1) bbb " +
            "on aaa.BATCH_ID=bbb.src_batch_id AND aaa.APPLY_STATUS is NULL or " +
            "aaa.APPLY_STATUS ='ERROR'", nativeQuery = true)
            //value = "select * from WK_ASSESSMENT where ROWNUM<=3", nativeQuery = true)
    List<WKAssessment> getEverything();

    WKAssessment getAssessmentListById(@Param("id") Long id);

    Optional<WKAssessment> findById(@Param("id") Long id);
    // @Modifying(clearAutomatically = true, flushAutomatically = true)
    // @Transactional
    // //@Lock(LockModeType.PESSIMISTIC_READ)
    // @Query("update WKAssessment set applyStatus ='APPLIED' where id = 21785")
    //     int updateApply();
    // // @Query("update WKAssessment set applyStatus =:status where id =:id")
    // //     int updateApply(@Param("id") BigInteger id, @Param("status") String status);
}