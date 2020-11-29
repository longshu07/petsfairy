package com.longshu.petsfairy.DTO;

import com.longshu.petsfairy.entity.Comment;
import com.longshu.petsfairy.entity.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description:
 *              将评论下面的回复加入其中
 *              将时间变成时间戳保存
 *              添加回复人的信息
 *              添加评论数和点赞数
 *              添加是否可以删除标志
 * @date :2020/3/29 20:30
 */
@Data
public class CommentDTO {
    private String commentId;

    private String content;

    private Long createTime;

    private String commentSelfId;

    private String replyCommentId;

    private String invitationId;

    private Integer pushState;

//    添加回复人的信息
    private List commentReplyList = new ArrayList<>();
    //评论人的信息
    private Customer customer;
    //评论人点赞数
//    private
//    评论数量
    private Integer counts;
}

