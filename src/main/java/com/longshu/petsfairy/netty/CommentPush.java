package com.longshu.petsfairy.netty;


import java.io.Serializable;
import java.util.Date;

/**
 * @author :龙叔
 * @description:通知有新的评论，返回一条评论信息，即评论实体
 * @date :2020/05/19 11:05
 */
public class CommentPush implements Serializable {

    private static final long serialVersionUID = -6263439055337928768L;
    private String commentId;

    private String content;

    private Date createTime;

    private String commentSelfId;

    private String replyCommentId;

    private String invitationId;

    private Integer pushState;

    private String nickname;

    private String avatarurl;

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

    @Override
    public String toString() {
        return "CommentPush{" +
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
}
