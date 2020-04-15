package com.example.demo.entity;

import java.math.BigInteger;
//import java.util.Date;
import java.util.Date;

import javax.persistence.*;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;

@Entity
@Table(name = "WK_ASSESSMENT")
public class Assessment {
    @Column(name = "UNIQUE_KEY", updatable = false, nullable = false)
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Column(name = "ROW_ID", nullable = true, length = 4)
    private BigInteger rowId;
   
    @Column(name = "ASSESSMENT_RESULT", nullable = true, length = 1000)
    private String assessmentResult;

    @Column(name = "CIMS1_KEY", nullable = true, length = 1000)
    private BigInteger cims1Key;

    @Column(name = "CREATED_BY", nullable = true, length = 30)
    private String createdBy;
    
    @Column(name = "CREATED_DTM", nullable = true, length = 255)
    private Date createdDTM;

    @Column(name = "UPDATED_BY", nullable = true, length = 255)
    private String updatedBy;

    @Column(name = "UPDATED_DTM", nullable = true, length = 255)
    private Date updatedDTM;

    @Column(name = "VERSION", nullable = true, length = 255)
    private Date version;

    @Column(name = "SRC_GEN_DATE_ID", nullable = false, length = 255)
    private BigInteger srcGenDateId;

    @Column(name = "UPLOAD_TIMESTAMP", nullable = false, length = 255)
    private Date uploadTS;
   
    @Column(name = "VERIFY_STATUS", nullable = true, length = 255)
    private BigInteger verifyStatus;

    @Column(name = "RESULT_MSG", nullable = true, length = 4000)
    private String resultMsg;
    
    @Column(name = "APPLY_STATUS", nullable = true, length = 20)
    private String applyStatus;

    @Column(name = "APPLY_DTM", nullable = true, length = 6)
    private Date applyDTM;

    public Assessment(Long id,
            BigInteger batchId, 
            String txnType,
            BigInteger assessmentId,
            BigInteger encounterId,
            String clinicCd, 
            String codeAssessmentCd, 
            BigInteger codeAssessmentFieldId,
            BigInteger rowId,
            String assessmentResult,
            BigInteger cims1Key,
            String createdBy, 
            Date createdDTM, 
            String updatedBy, 
            Date updatedDTM, 
            Date version,
            BigInteger srcGenDateId,
            Date uploadTS, 
            BigInteger verifyStatus, 
            String resultMsg, 
            String applyStatus, 
            Date applyDTM
            ) {
                this.id =id;
        this.batchId = batchId;
        this.txnType = txnType;
        this.assessmentId = assessmentId;
        this.encounterId = encounterId;
        this.clinicCd = clinicCd;
        this.codeAssessmentCd = codeAssessmentCd;
        this.codeAssessmentFieldId = codeAssessmentFieldId;

        this.rowId = rowId;
        this.assessmentResult = assessmentResult;
        this.createdBy = createdBy;
        this.createdDTM = createdDTM;
        this.updatedBy = updatedBy;
        this.updatedDTM = updatedDTM;
        this.version=version;
        this.srcGenDateId = srcGenDateId;
        this.uploadTS = uploadTS;
        this.verifyStatus = verifyStatus;
        this.resultMsg = resultMsg;
        this.applyStatus = applyStatus;
        this.applyDTM = applyDTM;
    }

    public Assessment() {
    }
    
    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    public Date getCreatedDTM() {
        return createdDTM;
    }

    public void setCreatedDTM(Date createdDTM) {
        this.createdDTM = createdDTM;
    }

    // public Date getApplyDTM() {
    //     return applyDTM;
    // }

    // public void setApplyDTM(final Date applyDTM) {
    //     this.applyDTM = applyDTM;
    // }
    
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(final String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(final String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public BigInteger getCims1Key() {
        return cims1Key;
    }

    public void setCims1Key(final BigInteger cims1Key) {
        this.cims1Key = cims1Key;
    }
    
    public BigInteger getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(final BigInteger verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public BigInteger getSrcGenDateId() {
        return srcGenDateId;
    }

    public void setSrcGenDateId(final BigInteger srcGenDateId) {
        this.srcGenDateId = srcGenDateId;
    }

    public Date getUploadTS() {
        return uploadTS;
    }

    public void setUploadTS(final Date uploadTS) {
        this.uploadTS = uploadTS;
    }

    public Date getUpdatedDTM() {
        return updatedDTM;
    }

    public void setUpdatedDTM(final Date updatedDTM) {
        this.updatedDTM = updatedDTM;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssessmentResult() {
        return assessmentResult;
    }

    public void setAssessmentResult(final String assessmentResult) {
        this.assessmentResult = assessmentResult;
    }

    public BigInteger getRowId() {
        return rowId;
    }

    public void setRowId(final BigInteger rowId) {
        this.rowId = rowId;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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
                ", codeAssessmentFieldId=" + codeAssessmentFieldId  +'\'' +
                ", rowId=" + rowId +'\'' +
                ", assessmentResult=" + assessmentResult +'\'' +
                ", cims1Key=" + cims1Key +'\'' +
                ", createdBy=" + createdBy +'\'' +
                ", createdDTM=" + createdDTM +'\'' +
                ", updatedBy=" + updatedBy +'\'' +
                ", updatedDTM=" + updatedDTM +'\'' +
                ", version=" + updatedDTM +'\'' +
                ", srcGenDateId=" + srcGenDateId +'\'' +
                ", uploadTS=" + uploadTS +'\'' +
                ", verifyStatus=" + verifyStatus  +'\'' +
                ", resultMsg=" + resultMsg +'\'' +
                ", applyStatus=" + applyStatus +'\'' +
                ", applyDTM=" + applyDTM +
                "}";
    };
}