package com.migration.assessment.daotarget;

import com.migration.assessment.entitytarget.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import java.math.BigInteger;

@Repository
//@Transactional
public interface AssessmentDao extends JpaRepository<Assessment, BigInteger> {
  
}