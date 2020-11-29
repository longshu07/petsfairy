package com.longshu.petsfairy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.DTO.CommentDTO;
import com.longshu.petsfairy.VO.CommentRequestVO;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.common.utils.pageHelper.PageUtils;
import com.longshu.petsfairy.dao.CommentMapper;
import com.longshu.petsfairy.dao.CustomerMapper;
import com.longshu.petsfairy.entity.Comment;
import com.longshu.petsfairy.entity.CommentExample;
import com.longshu.petsfairy.entity.Customer;
import com.longshu.petsfairy.entity.ReplyPush;
import com.longshu.petsfairy.service.CommentService;
import com.longshu.petsfairy.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description:评论逻辑实现
 * @date :2020/3/28 16:04
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    //查找用户信息
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 通过帖子id查找该帖子下面的评论数
     * @param invitationId
     * @return
     */
    @Override
    public Integer findCommentCountsByInvitationId(String invitationId){
        Integer  counts = commentMapper.findCommentCountsByInvitationId(invitationId);
        return counts;
    }

    /**
     * 发布评论
     * @param comment,pageRequest
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PageResult addComment(Comment comment, PageRequest pageRequest) {

         int flag = commentMapper.insert(comment);
         if (flag == 0){
             return null;
         }

         return getAllComments(pageRequest, comment.getInvitationId());
    }
    /**
     * 删除评论，删除完毕之后返回真假
     * @param comment
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean delComment(Comment comment) {
        CommentExample commentExample = new CommentExample();
        //帖子id，和发表评论人的id相统一才可以删除
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdEqualTo(comment.getCommentId());
        criteria.andCommentSelfIdEqualTo(comment.getCommentSelfId());
//        删除评论
        commentMapper.deleteByExample(commentExample);
//        删除评论下面的回复
        CommentExample commentExampleReply = new CommentExample();
        CommentExample.Criteria criteriaReply = commentExampleReply.createCriteria();
        criteriaReply.andInvitationIdEqualTo(comment.getCommentId());
        commentMapper.deleteByExample(commentExampleReply);


        return true;
    }
    /**
     * 获取某个帖子下面的全部的评论消息，并且分页处理
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult getAllComments(PageRequest pageRequest, String invitationId) {
        /**
         *  调用分页插件完成分页
         * @param pageRequest
         * @return
         */
        //当前页面页码
        int pageNum = pageRequest.getPageNum();
        //当前页面页码数量
        int pageSize = pageRequest.getPageSize();

        //通过评论时间的先后顺序
        /**
         * 就是使用这个插件中间只能有一次查询的操作语句，不能再添加其它语句（两行代码之间不能再有其他代码）！,
         * 以下三行一定要连续，不能有其他代码，
         * 否则
         * 这样获取的 pageInfo.getTotal()一直是当前的 pageSize总数，而不是查询的总条数。所以，我们最好不要在 pageHelper 两个语句中间插入其它语句
         *
         * PageHelper.startPage(pageNum, pageSize);
         * List<Invitation> invitationList = invitationMapper.selectAllInvitaionByPage();
         * PageInfo pageInfo = new PageInfo<>(invitaionDTOList);
         */
//
        //关键代码是 PageHelper.startPage(pageNum, pageSize)，将前台分页查询参数传入并拦截MyBtis执行实现分页效果。
        PageHelper.startPage(pageNum, pageSize);
//      从数据库中获取信息
        List<Comment> commentList = commentMapper.selectCommentByInvitationIdPage(invitationId);
        PageInfo pageInfo = new PageInfo<>(commentList);

        return PageUtils.getPageResult(pageInfo);
    }

    /**
     * 获取这些评论下面的回复
     * 通过已经查询出来的全部评论，通过这个评论id，是否在invitationid中，如果有，则有回复，
     * @param replyCommentId
     * @return
     */
    @Override
    public List<Comment> selectReplyByReplyCommentId(String replyCommentId) {
        return commentMapper.selectReplyByReplyCommentId(replyCommentId);
    }

    /**
     * 推送查询 查询还未被推送的评论消息,
     */

    @Override
    public List<ReplyPush> setCommentPush(String customerId){
//        System.out.println(customerId);
        //查找到评论，这里有invitationid
        List<ReplyPush> commentPush1  = commentMapper.selectCommentPush(customerId);
//        System.out.println(commentPush1.toString());
        //查找到回复，这里有用户信息
        List<ReplyPush> commentPush2 = commentMapper.selectReplyPush(customerId);
        List<ReplyPush> resultPush = new ArrayList<>();
//        System.out.println(commentPush1.toString());
        resultPush.addAll(commentPush1);
        resultPush.addAll(commentPush2);
        //排序
        Collections.sort(resultPush);
        return resultPush;
    }
    /**
     * 更新以签收消息
     */

    @Override
    public void updatePushComment(List<String> commentIdList){
        commentMapper.updatePushStateByCommentList(commentIdList);
    }

    /**
     * 根据评论id找到帖子id
     */
    @Override
    public String getInvitationIdByCommentId(String commentId){
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        List<Comment> list =  commentMapper.selectByExample(commentExample);
        return list.get(0).getInvitationId();
    }

    //通过id查询
    @Override
    public Comment setOne(String commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }

    /**
     * 选择性更新单个comment
     * @param comment
     */
    @Override
    public void updateComment(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
    }
}
