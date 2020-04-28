package com.migration.assessment.daotarget;

import com.migration.assessment.entitytarget.LogAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public interface LogAssessmentDao extends JpaRepository<LogAssessment, BigInteger> {
   
}