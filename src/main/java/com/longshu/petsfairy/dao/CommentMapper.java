package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.Comment;
import com.longshu.petsfairy.entity.CommentExample;
import com.longshu.petsfairy.entity.ReplyPush;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * 分页查询某个帖子下面的评论
     */
    List<Comment> selectCommentByInvitationIdPage(String invitationId);

    List<Comment> selectReplyByReplyCommentId(String replyCommentId);

    //通过帖子id查找帖子id下面的评论数量，不包括评论中的回复
    Integer findCommentCountsByInvitationId(String invitationId);

    /**
     * 联表查询 查询帖子下面的评论有没有被推送
     */
    List<ReplyPush> selectCommentPush(String customerId);

    /**
     * 联表查询 查询谁回复了谁
     * @param replyCommentId
     * @return
     */
    List<ReplyPush> selectReplyPush(String replyCommentId);

    /**
     * 修改已推送的消息标志
     * @param commentIdList
     */
    void updatePushStateByCommentList(List<String> commentIdList);
}