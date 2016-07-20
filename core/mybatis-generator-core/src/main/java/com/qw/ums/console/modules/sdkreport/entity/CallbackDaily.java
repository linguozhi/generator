package com.qw.ums.console.modules.sdkreport.entity;

import java.io.Serializable;

public class CallbackDaily implements Serializable {
    /**
     *  无意义
     */
    private Integer id;

    /**
     *  日期fmt:yyyy-MM-dd
     */
    private String daytime;

    /**
     *  游戏id
     */
    private Integer gameid;

    /**
     *  渠道id
     */
    private String chid;

    /**
     *  cpid
     */
    private String cpid;

    /**
     *  PageView
     */
    private Integer pv;

    /**
     *  UserView
     */
    private Integer uv;

    /**
     *  点击数
     */
    private Integer ccnt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public String getChid() {
        return chid;
    }

    public void setChid(String chid) {
        this.chid = chid;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
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

    public Integer getCcnt() {
        return ccnt;
    }

    public void setCcnt(Integer ccnt) {
        this.ccnt = ccnt;
    }
}