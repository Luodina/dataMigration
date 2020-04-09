package com.example.demo.entity;

import java.math.BigInteger;
//import java.util.Date;

import javax.persistence.*;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;

@Entity
@Table(name = "WK_ASSESSMENT")
public class Assessment {
    @Column(name = "UNIQUE_KEY", updatable = false, nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "BATCH_ID", nullable = false, length = 38)
    private BigInteger batchId;

    @Column(name = "TXN_TYPE", nullable = false, length = 1)
    private String txnType;

    @Column(name = "ASSESSMENT_ID", nullable = true, length = 10)
    private BigInteger assessmentId;
   
    @Column(name = "ENCOUNTER_ID", nullable = true, length = 14)
    private BigInteger encounterId;

    @Column(name = "CLINIC_CD", nullable = true, length = 50)
    private String clinicCd;
    
    @Column(name = "CODE_ASSESSMENT_CD", nullable = true, length = 10)
    private String codeAssessmentCd;

    @Column(name = "CODE_ASSESSMENT_FIELD_ID", nullable = true, length = 10)
    private BigInteger codeAssessmentFieldId;

    // @Column(name = "ROW_ID", nullable = true, length = 4)
    // private Integer rowId;
   
    // @Column(name = "ASSESSMENT_RESULT", nullable = true, length = 1000)
    // private String AssessmentResult;

    // @Column(name = "CREATED_BY", nullable = true, length = 30)
    // private String createdBy;
    
    // @Column(name = "CREATED_DTM", nullable = true, length = 255)
    // private Date createdDTM;

    // @Column(name = "UPDATED_BY", nullable = true, length = 255)
    // private String updatedBy;

    // @Column(name = "UPDATED_DTM", nullable = true, length = 255)
    // private Date updatedDTM;

    // @Column(name = "SRC_GEN_DATE_ID", nullable = false, length = 255)
    // private Integer srcGenDateId;

    // @Column(name = "UPLOAD_TIMESTAMP", nullable = false, length = 255)
    // private Date uploadTmp;
   
    // @Column(name = "VERIFY_STATUS", nullable = true, length = 255)
    // private Integer verifyStatus;

    // @Column(name = "RESULT_MSG", nullable = true, length = 4000)
    // private String resultMsg;
    
    // @Column(name = "APPLY_STATUS", nullable = true, length = 20)
    // private String applyStatus;

    // @Column(name = "APPLY_DTM", nullable = true, length = 6)
    // private Date applyDTM;

    public Assessment(
            final BigInteger batchId, final String txnType, final BigInteger assessmentId, final BigInteger encounterId,
            final String clinicCd, final String codeAssessmentCd, final BigInteger codeAssessmentFieldId) {
        this.batchId = batchId;
        this.txnType = txnType;
        this.assessmentId = assessmentId;
        this.encounterId = encounterId;
        this.clinicCd = clinicCd;
        this.codeAssessmentCd = codeAssessmentCd;
        this.codeAssessmentFieldId = codeAssessmentFieldId;
    }

    public Assessment() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public BigInteger getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(final BigInteger assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getClinicCd() {
        return clinicCd;
    }

    public void setClinicCd(final String clinicCd) {
        this.clinicCd = clinicCd;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(final String txnType) {
        this.txnType = txnType;
    }

    public BigInteger getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(final BigInteger encounterId) {
        this.encounterId = encounterId;
    }

    public BigInteger getBatchId() {
        return batchId;
    }

    public void setBatchId(final BigInteger batchId) {
        this.batchId = batchId;
    }

    public String getCodeAssessmentCd() {
        return codeAssessmentCd;
    }

    public void setCodeAssessmentCd(final String codeAssessmentCd) {
        this.codeAssessmentCd = codeAssessmentCd;
    }

    public BigInteger getCodeAssessmentFieldId() {
        return codeAssessmentFieldId;
    }

    public void setCodeAssessmentFieldId(final BigInteger codeAssessmentFieldId) {
        this.codeAssessmentFieldId = codeAssessmentFieldId;
    }
    @Override
    public String toString() {
        return  "Assessment{" +
                "id=" + id +
                ", batchId='" + batchId + '\'' +
                ", txnType=" + txnType +'\'' +
                ", assessmentId=" + assessmentId +'\'' +
                ", encounterId=" + encounterId +'\'' +
                ", clinicCd=" + clinicCd +'\'' +
                ", codeAssessmentCd=" + codeAssessmentCd +'\'' +
                ", codeAssessmentFieldId=" + codeAssessmentFieldId +
                '}';
    }
}