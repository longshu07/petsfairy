package com.longshu.petsfairy.service;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.Comment;
import com.longshu.petsfairy.entity.ReplyPush;

import java.util.List;

/**
 * 评论service接口
 *      *1、通过某个帖子id查询全部评论信息
 *      *2、查询某个帖子一共有多少个评论
 *      *3、用户删除自己的评论
 *      *4、用户发布评论
 */
public interface CommentService {

    /**
     * 通过帖子id获取该帖子下面的评论数量
     * @param invitationId
     * @return
     */
    Integer findCommentCountsByInvitationId(String invitationId);

    /**
     * 发布评论
     * @param
     * @return
     */
    PageResult addComment(Comment comment, PageRequest pageRequest);

    /**
     * 删除评论，删除完毕之后是否成功
     * @param comment
     * @return
     */
    Boolean delComment(Comment comment);

    /**
     * 获获取某个帖子下面的全部的评论消息，并且分页处理
     * @param pageRequest
     * @return
     */
    PageResult getAllComments(PageRequest pageRequest, String invitationId);

    /**
     * 通过已经查询出来的全部评论，通过这个评论id，是否在invitationid中，如果有，则有回复，获取这些评论下面的回复
     * @param replyCommentId
     * @return
     */
    List<Comment> selectReplyByReplyCommentId(String replyCommentId);

    /**
     * 推送查询 查询还未被推送的评论消息
     */
    List<ReplyPush> setCommentPush(String customerId);

    void updatePushComment(List<String> commentIdList);

    String getInvitationIdByCommentId(String commentId);

    //通过id查询
    Comment setOne(String commentId);

    //更新updata
    void updateComment(Comment comment);
}
