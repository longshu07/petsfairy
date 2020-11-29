package com.longshu.petsfairy.service;

import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.Invitation;
import com.longshu.petsfairy.entity.Likes;

import java.util.List;

/**
 * @author :龙叔
 * @description: 帖子
 * @date :2020/3/24 21:43
 */
public interface InvitationService {

    Invitation addInvitation(Invitation invitation);

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);

    //通过过个人宠物id查询这个宠物发的帖子，需要图片，文字就行
    PageInfo getInvitationByPersonPetId(String personPetId, PageRequest pageRequest);

    /**
     * 通过帖子id获取帖子的数据
     * @param invitationId
     * @return
     */
    Invitation getInvitationByInvitationId(String invitationId);

//    通过 帖子id和发帖人id确认删除帖子
    boolean delInvitaionByInvitaionIdAndInvitationMasterId(String invitationId, String invitationMasterId);
//  查询该用户发布过的全部帖子
    PageResult getInvitationByCustomerId(String customerId, PageRequest pageRequest);

    /**
     * 通过用户id三表联合查询获取被点过赞的帖子数据
     * 获取某个用户点过赞的全部帖子
     * @return
     */
    PageResult getAllBeLikedInvitationByCustomerId(String customerId,PageRequest pageRequest);

    /**
     *  通过帖子ids查询帖子数据
     * @param likesList
     * @return
     */
    PageResult getAllBeLikedInvitationByInvitationList(List<Likes> likesList, PageRequest pageRequest);
}
