package com.example.demo.entitystaging;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "JOB_CONTROL")
//@IdClass(JobControlId.class)
public class JobControl {
    // @Column(name = "UNIQUE_KEY", updatable = false, nullable = false)
    // @Id
    // // @GeneratedValue(strategy = GenerationType.AUTO)
    // private Long id;

    @Column(name = "MODULE_NAME", nullable = false, length = 15)
    private String moduleName;

    @Column(name = "BATCH_NAME", nullable = false, length = 50)
    private String batchName;

    @Column(name = "INST_CD", nullable = false, length = 10)
    private String instCd;

    @Column(name = "APPLICATION_CD", nullable = false, length = 10)
    private String applicationCd;

    @Column(name = "CURRENT_STEP", nullable = true, length = 50)
    private String currentStep;

    @Column(name = "PROCESS_STATUS", nullable = true, length = 1)
    private String processStatus;

    @Column(name = "LAST_UPDATE_DTM", nullable = true)
    private Date lastUpdateDTM;

    @Column(name = "PROCESS_DTM", nullable = true)
    @Id
    private String processDTM;

    @Column(name = "DATA_DATE", nullable = true)
    private Date dataDate;

    @Column(name = "DATA_DATE_ID", nullable = true, length = 38)
    private BigInteger dataDateId;

    @Column(name = "DATA_DTM", nullable = true)
    private String dataDTM;

    @Column(name = "COMMIT_DATA_DTM", nullable = true)
    private String commitDataDTM;

    @Column(name = "DATA_FROM_DTM", nullable = true)
    private String dataFromDTM;

    @Column(name = "DATA_TO_DTM", nullable = true)
    private String dataToDTM;

    @Column(name = "FAILED_COUNT", nullable = true, length = 38)
    private BigInteger failedCount;

    @Column(name = "EMPTY_COUNT", nullable = true, length = 38)
    private BigInteger emptyCount;

    @Column(name = "FREQ_UNIT", nullable = false, length = 2)
    private String freqUnit;

    @Column(name = "FREQ_VALUE", nullable = false, length = 38)
    private BigInteger freqValue;

    @Column(name = "MAX_FAIL_COUNT", nullable = false, length = 38)
    private BigInteger maxFailCount;

    @Column(name = "JOB_TYPE", nullable = false, length = 1)
    private String jobType;

    @Column(name = "BATCH_REC_COUNT", nullable = true, length = 38)
    private BigInteger batchRecCount;

    @Column(name = "IDLE_TIME", nullable = true, length =38)
    private BigInteger idleTime;

    @Column(name = "FILLER_ID1", nullable = true, length = 38)
    private BigInteger fillerID1;

    @Column(name = "FILLER_VAR2", nullable = true, length = 255)
    private String fillerVAR2;

    @Column(name = "FILLER_DTM3", nullable = true)
    private Date fillerDTM3;

    public JobControl(
        String moduleName,
        String batchName,
        String instCd,
        String applicationCd,
        String currentStep,
        String processStatus,
        Date lastUpdateDTM,
        String processDTM,
        Date dataDate,
        BigInteger dataDateId,
        String dataDTM,
        String commitDataDTM,
        String dataFromDTM,
        String dataToDTM,
        BigInteger failedCount,
        BigInteger emptyCount,
        String freqUnit,
        BigInteger freqValue,
        BigInteger maxFailCount,
        String jobType,
        BigInteger batchRecCount,
        BigInteger idleTime,
        BigInteger fillerID1,
        String fillerVAR2,
        Date fillerDTM3
        ) {
            this.moduleName=moduleName;
            this.batchName=batchName;
            this.instCd=instCd;
            this.applicationCd=applicationCd;
            this.currentStep=currentStep;
            this.processStatus=processStatus;
            this.lastUpdateDTM=lastUpdateDTM;
            this.processDTM=processDTM;
            this.dataDate=dataDate;
            this.dataDateId=dataDateId;
            this.dataDTM=dataDTM;
            this.commitDataDTM=commitDataDTM;
            this.dataFromDTM=dataFromDTM;
            this.dataToDTM=dataToDTM;
            this.failedCount=failedCount;
            this.emptyCount=emptyCount;
            this.freqUnit=freqUnit;
            this.freqValue=freqValue;
            this.maxFailCount=maxFailCount;
            this.jobType=jobType;
            this.batchRecCount=batchRecCount;
            this.idleTime=idleTime;
            this.fillerID1=fillerID1;
            this.fillerVAR2=fillerVAR2;
            this.fillerDTM3 =fillerDTM3;
        }

        @Override
        public String toString() {
            return  "JobControl{" +
                "moduleName=" + moduleName +
                ", batchName='" + batchName + '\'' +
                ", instCd=" + instCd +'\'' +
                ", applicationCd=" + applicationCd +'\'' +
                ", currentStep=" + currentStep +'\'' +
                ", processStatus=" + processStatus +'\'' +
                ", lastUpdateDTM=" + lastUpdateDTM +'\'' +
                ", processDTM=" + processDTM  +'\'' +
                ", dataDate=" + dataDate +'\'' +
                ", dataDateId=" + dataDateId +'\'' +
                ", dataDTM=" + dataDTM +'\'' +
                ", commitDataDTM=" + commitDataDTM +'\'' +
                ", dataFromDTM=" + dataFromDTM +'\'' +
                ", dataToDTM=" + dataToDTM +'\'' +
                ", failedCount=" + failedCount +'\'' +
                ", emptyCount=" + emptyCount +'\'' +
                ", freqUnit=" + freqUnit +'\'' +
                ", freqValue=" + freqValue +'\'' +
                ", maxFailCount=" + maxFailCount  +'\'' +
                ", jobType=" + jobType +'\'' +
                ", batchRecCount=" + batchRecCount +'\'' +
                ", idleTime=" + idleTime  +'\'' +
                ", fillerID1=" + fillerID1 +'\'' +
                ", fillerVAR2=" + fillerVAR2 +'\'' +
                ", fillerDTM3=" + fillerDTM3 +
                "}";
        };

        public JobControl() {
        }

        public String getDataDTM() {
            return dataDTM;
        }

        public void setDataDTM(String dataDTM) {
            this.dataDTM = dataDTM;
        }

        public String getCommitDataDTM() {
            return commitDataDTM;
        }

        public void setCommitDataDTM(String commitDataDTM) {
            this.commitDataDTM = commitDataDTM;
        }

        public String getDataFromDTM() {
            return dataFromDTM;
        }

        public void setDataFromDTM(String dataFromDTM) {
            this.dataFromDTM = dataFromDTM;
        }

        public String getDataToDTM() {
            return dataToDTM;
        }

        public void setCurrentStep(String currentStep) {
            this.currentStep = currentStep;
        }

        public String getCurrentStep() {
            return currentStep;
        }

        public void setDataToDTM(String dataToDTM) {
            this.dataToDTM = dataToDTM;
        }
        
        public String getJobType() {
            return jobType;
        }

        public void setJobType(String jobType) {
            this.jobType = jobType;
        }

        public String getInstCd() {
            return instCd;
        }

        public void setInstCd(String instCd) {
            this.instCd = instCd;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getApplicationCd() {
            return applicationCd;
        }

        public void setApplicationCd(String applicationCd) {
            this.applicationCd = applicationCd;
        }

        public String getBatchName() {
            return batchName;
        }

        public void setBatchName(String batchName) {
            this.batchName = batchName;
        }
}