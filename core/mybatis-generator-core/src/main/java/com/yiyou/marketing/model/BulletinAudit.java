package com.yiyou.marketing.model;

import java.io.Serializable;
import java.util.Date;

public class BulletinAudit implements Serializable {
    /**
     *  自增id
     */
    private Integer id;

    /**
     *  公告id
     */
    private Integer bulletinId;

    /**
     *  审核人
     */
    private String auditor;

    /**
     *  审核状态。0：未提交；1：待审核；2：审核通过；3：审核退回
     */
    private Integer status;

    /**
     *  审核意见
     */
    private String remark;

    /**
     *  创建
     */
    private Date createTime;

    /**
     *  修改时间
     */
    private Date updateTime;

    /**
     *  是否删除。0：不删除；1：已删除
     */
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBulletinId() {
        return bulletinId;
    }

    public void setBulletinId(Integer bulletinId) {
        this.bulletinId = bulletinId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}