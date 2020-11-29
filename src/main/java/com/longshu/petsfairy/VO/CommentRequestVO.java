package com.longshu.petsfairy.VO;

import lombok.Data;

import java.util.Date;

/**
 * @author :龙叔
 * @description:接收前端发送的评论类本身的内容，以及分页消息
 * @date :2020/3/29 16:42
 */
@Data
public class CommentRequestVO {
    private String commentId;

    private String content;

    private Date createTime;

    private String commentSelfId;

    private String replyCommentId;

    private String invitationId;
    //是否被推送 0 否， 1已推送
    private Integer pushState;

    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
}
