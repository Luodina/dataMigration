// package hk.org.ha.drm.dao;

// import java.io.IOException;
// import java.io.Reader;
// import java.math.BigDecimal;
// import java.sql.Clob;
// import java.sql.SQLException;
// import java.sql.Timestamp;
// import java.util.ArrayList;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.Iterator;
// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
// import javax.persistence.Query;

// import org.apache.commons.io.IOUtils;

// import org.apache.commons.lang3.StringUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Order;

// // import hk.org.ha.drm.entitySearchResultVo.DrmDetailReportVo;
// // import hk.org.ha.drm.entitySearchResultVo.DrmPatientOrderItemSearchResultVo;
// // import hk.org.ha.drm.entitySearchResultVo.DrmSummaryReportVo;
// // import hk.org.ha.drm.util.DateUtils;
// // import hk.org.ha.drm.vo.criteria.DrmPatientOrderItemCriteriaModal;

// public class customDataMigrationRepositoryImpl implements DrmPatientOrderItemRepositoryCustom {

// 	private Logger logger = LoggerFactory.getLogger(getClass());
	
//     @PersistenceContext
//     private EntityManager em;
    
//     @Override
//     public List<DrmSummaryReportVo> getDrmSummaryReportVo(Date fromDate, Date toDate, Long scheduleId) {
//     	StringBuilder sqlBuilder = new StringBuilder();
//     	sqlBuilder.append(" select CLUSTER_CODE, ITEM_CODE                                                                                                                                                                                                                                                                                                                         ");
//     	sqlBuilder.append(" , NVL(max(no_of_replacement), 0) as no_of_replacement                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" , NVL(max(no_of_patient), 0) as no_of_patient                                                                                                                                                                                                                                                                                                          ");
//     	sqlBuilder.append(" , NVL(max(no_redisp_qty), 0) as no_redisp_qty                                                                                                                                                                                                                                                                                                          ");
//     	sqlBuilder.append(" , NVL(max(acc_no_of_replacement), 0) as acc_no_of_replacement                                                                                                                                                                                                                                                                                          ");
//     	sqlBuilder.append(" , NVL(max(acc_no_of_patient), 0) as acc_no_of_patient                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" , NVL(max(acc_no_redisp_qty), 0) as acc_no_redisp_qty                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" , NVL(max(out_no_of_replacement), 0) as out_no_of_replacement                                                                                                                                                                                                                                                                                          ");
//     	sqlBuilder.append(" , NVL(max(out_no_of_patient), 0) as out_no_of_patient                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" , NVL(max(out_no_redisp_qty), 0) as out_no_redisp_qty                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" from (                                                                                                                                                                                                                                                                                                                                                 ");
//     	sqlBuilder.append(" select REDISP_ORDER_ITEM.CLUSTER_CODE                                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" ,DRM_PATIENT_ORDER_ITEM.ITEM_CODE                                                                                                                                                                                                                                                                                                                      ");
//     	sqlBuilder.append(" , count(case when REDISP_ORDER_ITEM.CREATE_DATE between :fromDate and :toDate then DRM_PATIENT_ORDER_ITEM.DISP_ORDER_ITEM_ID else  null end) as no_of_replacement                                                                                                                                                                                      ");
//     	sqlBuilder.append(" , count( distinct case when REDISP_ORDER_ITEM.CREATE_DATE between :fromDate and :toDate then DRM_PATIENT_ORDER_ITEM.PO_HKID else  null end) as no_of_patient                                                                                                                                                                                           ");
//     	sqlBuilder.append(" , sum( case when REDISP_ORDER_ITEM.CREATE_DATE between :fromDate and :toDate then REDISP_ORDER_ITEM.REDISP_QTY else 0 end) as no_redisp_qty                                                                                                                                                                                                            ");
//     	sqlBuilder.append(" , count(case when REDISP_ORDER_ITEM.CREATE_DATE between REDISP_SCHEDULE.EFFECTIVE_DATE and :toDate then DRM_PATIENT_ORDER_ITEM.DISP_ORDER_ITEM_ID else  null end) as acc_no_of_replacement                                                                                                                                                             ");
//     	sqlBuilder.append(" , count( distinct case when REDISP_ORDER_ITEM.CREATE_DATE between REDISP_SCHEDULE.EFFECTIVE_DATE and :toDate then DRM_PATIENT_ORDER_ITEM.PO_HKID else  null end) as acc_no_of_patient                                                                                                                                                                  ");
//     	sqlBuilder.append(" , sum( case when REDISP_ORDER_ITEM.CREATE_DATE between REDISP_SCHEDULE.EFFECTIVE_DATE and :toDate then REDISP_ORDER_ITEM.REDISP_QTY else 0 end) as acc_no_redisp_qty                                                                                                                                                                                   ");
//     	sqlBuilder.append(" , null as out_no_of_replacement                                                                                                                                                                                                                                                                                                                        ");
//     	sqlBuilder.append(" , null as out_no_of_patient                                                                                                                                                                                                                                                                                                                            ");
//     	sqlBuilder.append(" , null as out_no_redisp_qty                                                                                                                                                                                                                                                                                                                            ");
//     	sqlBuilder.append(" from REDISP_ORDER_ITEM REDISP_ORDER_ITEM                                                                                                                                                                                                                                                                                                               ");
//     	sqlBuilder.append(" inner join RPT_CLUSTER RPT_CLUSTER ON RPT_CLUSTER.CLUSTER_CODE = REDISP_ORDER_ITEM.CLUSTER_CODE                                                                                                                                                                                                                                                        ");
//     	sqlBuilder.append(" inner join DRM_PATIENT_ORDER_ITEM DRM_PATIENT_ORDER_ITEM on REDISP_ORDER_ITEM.DISP_ORDER_ITEM_ID = DRM_PATIENT_ORDER_ITEM.DISP_ORDER_ITEM_ID and DRM_PATIENT_ORDER_ITEM.STATUS = 'A'                                                                                                                                                                   ");
//     	sqlBuilder.append(" inner join REDISP_SCHEDULE REDISP_SCHEDULE ON DRM_PATIENT_ORDER_ITEM.REDISP_SCHEDULE_ID = REDISP_SCHEDULE.ID                                                                                                                                                                                                                                           ");
//     	sqlBuilder.append(" where REDISP_SCHEDULE.ID = :scheduleId and DRM_PATIENT_ORDER_ITEM.STATUS = 'A'                                                                                                                                                                                                                                                                         ");
//     	sqlBuilder.append(" GROUP BY REDISP_ORDER_ITEM.CLUSTER_CODE ,DRM_PATIENT_ORDER_ITEM.ITEM_CODE                                                                                                                                                                                                                                                                              ");
//     	sqlBuilder.append(" union                                                                                                                                                                                                                                                                                                                                                  ");
//     	sqlBuilder.append(" select RPT_CLUSTER.CLUSTER_CODE AS CLUSTER_CODE                                                                                                                                                                                                                                                                                                        ");
//     	sqlBuilder.append(" ,DRM_PATIENT_ORDER_ITEM.ITEM_CODE                                                                                                                                                                                                                                                                                                                      ");
//     	sqlBuilder.append(" , null as no_of_replacement                                                                                                                                                                                                                                                                                                                            ");
//     	sqlBuilder.append(" , null as no_of_patient                                                                                                                                                                                                                                                                                                                                ");
//     	sqlBuilder.append(" , null as no_redisp_qty                                                                                                                                                                                                                                                                                                                                ");
//     	sqlBuilder.append(" , null as acc_no_of_replacement                                                                                                                                                                                                                                                                                                                        ");
//     	sqlBuilder.append(" , null as acc_no_of_patient                                                                                                                                                                                                                                                                                                                            ");
//     	sqlBuilder.append(" , null as acc_no_redisp_qty                                                                                                                                                                                                                                                                                                                            ");
//     	sqlBuilder.append(" , count(case when 1 = 1 then DRM_PATIENT_ORDER_ITEM.DISP_ORDER_ITEM_ID else  null end) as out_no_of_replacement                                                                                                                                                                                                                                        ");
//     	sqlBuilder.append(" , count( distinct case when 1 = 1 then DRM_PATIENT_ORDER_ITEM.PO_HKID else  null end) as out_no_of_patient                                                                                                                                                                                                                                             ");
//     	sqlBuilder.append(" , sum( case when DRM_PATIENT_ORDER_ITEM.REDISP_STATUS = 'P' then DRM_PATIENT_ORDER_ITEM.REMAIN_REDISP_QTY when DRM_PATIENT_ORDER_ITEM.REDISP_STATUS = 'N' then CEIL(DRM_PATIENT_ORDER_ITEM.DISP_QTY * ((TRUNC(DRM_PATIENT_ORDER_ITEM.ISSUE_DATE) + DURATION_IN_DAY) - to_date(:today,'YYYYMMDDHH24MISS')) / DURATION_IN_DAY) else 0 end) as out_no_redisp_qty ");
//     	sqlBuilder.append(" from DRM_PATIENT_ORDER_ITEM DRM_PATIENT_ORDER_ITEM                                                                                                                                                                                                                                                                                                     ");
//     	sqlBuilder.append(" inner join DISP_INST_RPT_MAPPING DISP_INST_RPT_MAPPING ON DISP_INST_RPT_MAPPING.HOSP_CODE = DRM_PATIENT_ORDER_ITEM.HOSP_CODE AND DISP_INST_RPT_MAPPING.WORKSTORE_CODE = DRM_PATIENT_ORDER_ITEM.WORKSTORE_CODE                                                                                                                                          ");
//     	sqlBuilder.append(" inner join RPT_INST RPT_INST ON RPT_INST.INSTITUTION = DISP_INST_RPT_MAPPING.INSTITUTION                                                                                                                                                                                                                                                               ");
//     	sqlBuilder.append(" inner join RPT_CLUSTER RPT_CLUSTER ON RPT_CLUSTER.CLUSTER_CODE = RPT_INST.CLUSTER_CODE                                                                                                                                                                                                                                                                 ");
//     	sqlBuilder.append(" inner join REDISP_SCHEDULE REDISP_SCHEDULE ON DRM_PATIENT_ORDER_ITEM.REDISP_SCHEDULE_ID = REDISP_SCHEDULE.ID                                                                                                                                                                                                                                           ");
//     	sqlBuilder.append(" WHERE DRM_PATIENT_ORDER_ITEM.DEATH_FLAG = 0 AND DRM_PATIENT_ORDER_ITEM.REDISP_STATUS IN ('P','N') AND ((TRUNC(DRM_PATIENT_ORDER_ITEM.ISSUE_DATE) + DURATION_IN_DAY) > to_date(:today,'YYYYMMDDHH24MISS'))                                                                                                                                                    ");
//     	sqlBuilder.append(" and REDISP_SCHEDULE.ID = :scheduleId and DRM_PATIENT_ORDER_ITEM.STATUS = 'A'                                                                                                                                                                                                                                                                           ");
//     	sqlBuilder.append(" GROUP BY RPT_CLUSTER.CLUSTER_CODE ,DRM_PATIENT_ORDER_ITEM.ITEM_CODE)                                                                                                                                                                                                                                                                                   ");
//     	sqlBuilder.append(" group by CLUSTER_CODE, ITEM_CODE                                                                                                                                                                                                                                                                                                                       ");
//     	sqlBuilder.append(" order by ITEM_CODE, CLUSTER_CODE                                                                                                                                                                                                                                                                                                                       ");

         
//         Query query = em.createNativeQuery(sqlBuilder.toString());
        
//         query.setParameter("fromDate", fromDate);
//         query.setParameter("toDate", toDate);
//         query.setParameter("today", DateUtils.convertDateToString(DateUtils.truncate(toDate, Calendar.DATE), "yyyyMMddHHmmss"));
//         query.setParameter("scheduleId", scheduleId);
        
//         List<Object[]> resultList = query.getResultList();
//         List<DrmSummaryReportVo> list = new ArrayList<DrmSummaryReportVo>();
//         for (Object[] array : resultList) {
//         	DrmSummaryReportVo drmSummaryReportVo = new DrmSummaryReportVo();
//         	drmSummaryReportVo.setClusterCode(array[0]==null ? null : array[0].toString());
//         	drmSummaryReportVo.setItemCode(array[1]==null ? null : array[1].toString());
//         	drmSummaryReportVo.setNoOfReplacement(array[2]==null ? null :((Number) array[2]).longValue());
//         	drmSummaryReportVo.setNoOfPatient(array[3]==null ? null :((Number) array[3]).longValue());
//         	drmSummaryReportVo.setNoRedispQty(array[4]==null ? null :((Number) array[4]).longValue());
//         	drmSummaryReportVo.setAccNoOfReplacement(array[5]==null ? null :((Number) array[5]).longValue());
//         	drmSummaryReportVo.setAccNoOfPatient(array[6]==null ? null :((Number) array[6]).longValue());
//         	drmSummaryReportVo.setAccNoRedispQty(array[7]==null ? null :((Number) array[7]).longValue());
//         	drmSummaryReportVo.setOutNoOfReplacement(array[8]==null ? null :((Number) array[8]).longValue());
//         	drmSummaryReportVo.setOutNoOfPatient(array[9]==null ? null :((Number) array[9]).longValue());
//         	drmSummaryReportVo.setOutNoRedispQty(array[10]==null ? null :((Number) array[10]).longValue());
        	
//         	list.add(drmSummaryReportVo);
//         }
        
//         return list;
//     }
// }