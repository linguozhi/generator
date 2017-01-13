package com.qw.ums.console.modules.sdkreport.model;

import java.io.Serializable;

public class SubscribeStatMonthly implements Serializable {
    /**
     *  id
     */
    private Integer id;

    /**
     *  月日期:201612
     */
    private Integer yearMonth;

    /**
     *  sdk游戏id
     */
    private Integer sdkgid;

    /**
     *  tt游戏id
     */
    private Integer gid;

    /**
     *  tt游戏圈id
     */
    private Integer cid;

    /**
     *  页面pv数
     */
    private Integer pv;

    /**
     *  页面uv数，按设备去重
     */
    private Integer uv;

    /**
     *  新增预约数
     */
    private Integer ncnt;

    /**
     *  预约下载数
     */
    private Integer dcnt;

    /**
     *  预约安装数
     */
    private Integer scnt;

    /**
     *  预约激活数
     */
    private Integer acnt;

    /**
     *  预约注册数
     */
    private Integer rcnt;

    /**
     *  预约登录数
     */
    private Integer lcnt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getSdkgid() {
        return sdkgid;
    }

    public void setSdkgid(Integer sdkgid) {
        this.sdkgid = sdkgid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getNcnt() {
        return ncnt;
    }

    public void setNcnt(Integer ncnt) {
        this.ncnt = ncnt;
    }

    public Integer getDcnt() {
        return dcnt;
    }

    public void setDcnt(Integer dcnt) {
        this.dcnt = dcnt;
    }

    public Integer getScnt() {
        return scnt;
    }

    public void setScnt(Integer scnt) {
        this.scnt = scnt;
    }

    public Integer getAcnt() {
        return acnt;
    }

    public void setAcnt(Integer acnt) {
        this.acnt = acnt;
    }

    public Integer getRcnt() {
        return rcnt;
    }

    public void setRcnt(Integer rcnt) {
        this.rcnt = rcnt;
    }

    public Integer getLcnt() {
        return lcnt;
    }

    public void setLcnt(Integer lcnt) {
        this.lcnt = lcnt;
    }
}