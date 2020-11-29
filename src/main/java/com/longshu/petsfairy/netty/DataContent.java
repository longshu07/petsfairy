package com.longshu.petsfairy.netty;


import java.io.Serializable;

/**
 * @author :龙叔
 * @description:    聊天内容
 * @date :2019/8/18 15:35
 */
public class DataContent implements Serializable {


    private static final long serialVersionUID = -2993272038170708468L;
    private Integer action;//动作类型
    private CommentPush commentPush;//推送评论内容
    private String extand;//扩展字段

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public CommentPush getCommentPush() {
        return commentPush;
    }

    public void setCommentPush(CommentPush commentPush) {
        this.commentPush = commentPush;
    }

    public String getExtand() {
        return extand;
    }

    public void setExtand(String extand) {
        this.extand = extand;
    }

    @Override
    public String toString() {
        return "DataContent{" +
                "action=" + action +
                ", commentPush=" + commentPush +
                ", extand='" + extand + '\'' +
                '}';
    }
}
