package com.example.demo.entity;
import javax.persistence.*;

@Entity
@Table(name = "stg_for_cims2_intf")
public class StgForCims2Intf {
    @Column(name = "STG_FOR_CIMS2_INTF_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DATA_DOMAIN", nullable = true, length = 255)
    private String domain;

    @Column(name = "PROCESS_STATUS", nullable = true, length = 255)
    private String status;

    public StgForCims2Intf(String domain, String status) {
        this.domain = domain;
        this.status = status;
    }
    
    protected StgForCims2Intf() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void getDomain(String domain) {
        this.domain = domain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StgForCims2Intf{" +
                "id=" + id +
                ", domain='" + domain + '\'' +
                ", status=" + status +
                '}';
    }
}