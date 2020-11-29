package com.longshu.petsfairy.entity;

import lombok.Data;

@Data
public class Follow extends FollowKey {
    private String followId;

    private Integer status;

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId == null ? null : followId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}