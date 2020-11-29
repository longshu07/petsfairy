package com.longshu.petsfairy.entity;

import java.util.Date;

/**
 * @author :龙叔
 * @description: 评论推送返回的内容
 * @date :2020/5/19 17:03
 */
public class ReplyPush implements Comparable<ReplyPush>{
    private String commentId;

    private String content;

    private Date createTime;

    private String commentSelfId;

    private String replyCommentId;

    private String invitationId;

    private Integer pushState;

    private String nickname;

    private String avatarurl;

    @Override
    public int compareTo(ReplyPush o) {
        return o.getCreateTime().compareTo(this.getCreateTime());
    }

    @Override
    public String toString() {
        return "ReplyPush{" +
                "commentId='" + commentId + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", commentSelfId='" + commentSelfId + '\'' +
                ", replyCommentId='" + replyCommentId + '\'' +
                ", invitationId='" + invitationId + '\'' +
                ", pushState=" + pushState +
                ", nickname='" + nickname + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                '}';
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        this.commentSelfId = commentSelfId;
    }

    public String getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(String replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getPushState() {
        return pushState;
    }

    public void setPushState(Integer pushState) {
        this.pushState = pushState;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }


}
