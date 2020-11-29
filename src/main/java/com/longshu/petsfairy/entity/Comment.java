package com.longshu.petsfairy.entity;

import java.util.Date;

public class Comment {
    private String commentId;

    private String content;

    private Date createTime;

    private String commentSelfId;

    private String replyCommentId;

    private String invitationId;

    private Integer pushState;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
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

    public String getCommentSelfId() {
        return commentSelfId;
    }

    public void setCommentSelfId(String commentSelfId) {
        this.commentSelfId = commentSelfId == null ? null : commentSelfId.trim();
    }

    public String getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(String replyCommentId) {
        this.replyCommentId = replyCommentId == null ? null : replyCommentId.trim();
    }

    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId == null ? null : invitationId.trim();
    }

    public Integer getPushState() {
        return pushState;
    }

    public void setPushState(Integer pushState) {
        this.pushState = pushState;
    }
}