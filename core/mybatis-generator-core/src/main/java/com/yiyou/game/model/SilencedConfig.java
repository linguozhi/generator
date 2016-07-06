package com.yiyou.game.model;

import java.io.Serializable;
import java.util.Date;

public class SilencedConfig implements Serializable {
    /**
     *  
     */
    private Long id;

    /**
     *  游戏ID
     */
    private Integer gameId;

    /**
     *  渠道ID
     */
    private String channelId;

    /**
     *  状态
     */
    private String status;

    /**
     *  下载地址
     */
    private String url;

    /**
     *  md5校验码
     */
    private String checkcode;

    /**
     *  创建时间
     */
    private Date ctime;

    /**
     *  开始时间
     */
    private Date beginTime;

    /**
     *  结束时间
     */
    private Date endTime;

    /**
     *  包id， 多个以英文逗号隔开
     */
    private String cpIds;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCpIds() {
        return cpIds;
    }

    public void setCpIds(String cpIds) {
        this.cpIds = cpIds;
    }
}