package com.longshu.petsfairy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.DTO.InvitaionDTO;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.common.utils.pageHelper.PageUtils;
import com.longshu.petsfairy.dao.CommentMapper;
import com.longshu.petsfairy.dao.InvitationMapper;
import com.longshu.petsfairy.entity.*;
import com.longshu.petsfairy.service.InvitationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description:帖子逻辑操作
 * @date :2020/3/24 21:43
 */
@Service
public class InvitationServiceImpl implements InvitationService {
    @Resource
    private InvitationMapper invitationMapper;

//    评论的dao层
    @Resource
    private CommentMapper commentMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Invitation addInvitation(Invitation invitation){
        invitation.setCreateTime(new Date());
        int flag = invitationMapper.insert(invitation);
        if (flag == 0){
            return null;
        }
        invitation = invitationMapper.selectByPrimaryKey(invitation.getInvitationId());
        return invitation;
    }

    /**
     * 服务实现类通过调用分页插件完成最终的分页查询，
     * 关键代码是 PageHelper.startPage(pageNum, pageSize)，将前台分页查询参数传入并拦截MyBtis执行实现分页效果。
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    /**
     * 通过个人宠物id查询这个宠物发的帖子，需要图片，文字就行
     * @param personPetId
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo getInvitationByPersonPetId(String personPetId, PageRequest pageRequest) {
        InvitationExample invitationExample = new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andDeleteFlagEqualTo(0);
        criteria.andPersonPetsIdEqualTo(personPetId);
        invitationExample.setOrderByClause("create_time DESC");
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Invitation> invitationList = invitationMapper.selectByExample(invitationExample);
        PageInfo pageInfo = new PageInfo<>(invitationList);
        return pageInfo;
    }

    /**
     * 通过帖子id获取帖子数据
     * @param invitationId
     * @return
     */
    @Override
    public Invitation getInvitationByInvitationId(String invitationId) {
        Invitation invitation = invitationMapper.selectByPrimaryKey(invitationId);
        return invitation;
    }

    /**
     * 删除
     *
     * 通过 帖子id和发帖人id确认删除帖子,一并删除该帖子下面的评论数据
     * @param invitationId
     * @param invitationMasterId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean delInvitaionByInvitaionIdAndInvitationMasterId(String invitationId, String invitationMasterId) {

        int invitationDelFlag = 0;
        int commentDelFlag = 0;
        int replyDelFlag = 0;

//      通过帖子id查找到该帖子下面的评论，再通过该评论id查询该评论下面的回复
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andInvitationIdEqualTo(invitationId);
        List<Comment>  commentList = commentMapper.selectByExample(commentExample);
        if (commentList.size() > 0){
            for (Comment comment :commentList){
                CommentExample commentExampleReply = new CommentExample();
//              找到该评论下面的回复们
                commentExampleReply.createCriteria().andInvitationIdEqualTo(comment.getCommentId());
//              删除该评论下面的回复回复
                replyDelFlag = commentMapper.deleteByExample(commentExampleReply);
            }
        }

//      删除全部评论
        commentDelFlag = commentMapper.deleteByExample(commentExample);

//      删除帖子，修改其删除标志位1
        InvitationExample invitationExample = new InvitationExample();
        InvitationExample.Criteria criteria = invitationExample.createCriteria();
        criteria.andInvitationIdEqualTo(invitationId);
        criteria.andInvitationMasterIdEqualTo(invitationMasterId);
        Invitation invitation = new Invitation();
        invitation.setInvitationId(invitationId);
        invitation.setDeleteFlag(1);
        invitationDelFlag = invitationMapper.updateByPrimaryKeySelective(invitation);
//        invitationDelFlag = invitationMapper.deleteByExample(invitationExample);

        if (invitationDelFlag <= 0){
            return false;
        }
        return true;
    }


    /**
     *查询该用户发布过的全部帖子
     * @param customerId
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult getInvitationByCustomerId(String customerId, PageRequest pageRequest) {
        InvitationExample invitationExample = new InvitationExample();
        InvitationExample.Criteria criteria =  invitationExample.createCriteria();
        criteria.andInvitationMasterIdEqualTo(customerId);
        criteria.andDeleteFlagEqualTo(0);
        invitationExample.setOrderByClause("create_time DESC");

//        开始分页
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Invitation>  invitationList = invitationMapper.selectByExample(invitationExample);
        PageInfo pageInfo = new PageInfo<>(invitationList);
//        PageUtils.getPageResult(pageInfo);
        return PageUtils.getPageResult(pageInfo);
    }

    /**
     * 获取某个用户点过赞的全部帖子
     * @return
     */
    @Override
    public PageResult getAllBeLikedInvitationByCustomerId(String customerId,PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Invitation> beLikedInvitationList = invitationMapper.getAllBeLikedInvitationByCustomerId(customerId);
        PageInfo pageInfo = new PageInfo<>(beLikedInvitationList);
        return PageUtils.getPageResult(pageInfo);
    }

    /**
     *  通过帖子ids查询帖子数据
     * @param likesList
     * @return
     */
    @Override
    public PageResult getAllBeLikedInvitationByInvitationList(List<Likes> likesList, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Invitation> beLikedInvitationList = invitationMapper.getAllBeLikedInvitationByInvitationList(likesList);
        PageInfo pageInfo = new PageInfo<>(beLikedInvitationList);
        return PageUtils.getPageResult(pageInfo);
    }


    /**
     *  调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo getPageInfo(PageRequest pageRequest){
        //当前页面页码
        int pageNum = pageRequest.getPageNum();
        //当前页面页码数量
        int pageSize = pageRequest.getPageSize();
        //返回给前端的数据
//        List<InvitaionDTO> invitaionDTOList = new ArrayList<>();
        //通过时间的先后查询
        InvitationExample invitationExample = new InvitationExample();

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
        List<Invitation> invitationList = invitationMapper.selectAllInvitaionByPage();
        PageInfo pageInfo = new PageInfo<>(invitationList);

//        for (Invitation invitation :invitationList){
//            invitaionDTOList.add(InvitaionToInvitaonDTO.invitaionToInvitaonDTO(invitation));
//        }
        return pageInfo;
    }




}
