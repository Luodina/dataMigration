package com.example.demo.entitytarget;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ASSESSMENT", schema="ASSESSMENT")
public class Assessment {
    @Column(name = "ASSESSMENT_ID", nullable = false, length = 10)
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
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
  
    public Assessment(BigInteger  assessmentId,
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
            Date version
            ) {                
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

   
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    public BigInteger getCims1Key() {
        return cims1Key;
    }

    public void setCims1Key(final BigInteger cims1Key) {
        this.cims1Key = cims1Key;
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

    public BigInteger getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(final BigInteger encounterId) {
        this.encounterId = encounterId;
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
                " assessmentId=" + assessmentId +'\'' +
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
                ", version=" + updatedDTM +
                "}";
    };
}