package com.example.demo.daotarget;

import com.example.demo.entitytarget.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
// import java.util.Optional;

@Repository
//@Transactional
public interface AssessmentDao extends JpaRepository<Assessment, BigInteger> {
    // @Query(value = "select * from ASSESSMENT.ASSESSMENT where ROWNUM<=3", nativeQuery = true)
    // List<Assessment> getEverything(); 

   
}