package com.longshu.petsfairy.entity;

import java.util.Date;

public class ChatMsg {
    private String id;

    private String content;

    private Date createTime;

    private String toWhere;

    private String formWhere;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere == null ? null : toWhere.trim();
    }

    public String getFormWhere() {
        return formWhere;
    }

    public void setFormWhere(String formWhere) {
        this.formWhere = formWhere == null ? null : formWhere.trim();
    }
}