package com.evol.nmsg.domain;

import java.io.Serializable;
import java.util.UUID;
import java.util.Date;

/**
 * 留言和回复
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String userId;
    private String subject;
    private String content;
    private int model;
    private Date createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {  this.model = model; }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }



}
