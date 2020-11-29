package com.longshu.petsfairy.service;

import com.longshu.petsfairy.VO.LikesVO;
import com.longshu.petsfairy.entity.Likes;
import java.util.List;

/**
 * (Likes)表服务接口
 *
 * @author makejava
 * @since 2020-04-16 16:36:40
 */
public interface LikesService {

//  插入
    Boolean insertLike(Likes likes);

    Boolean updateLikes(Likes likes);

//  根据当前用户的id和帖子id判断这个用户是否存在于数据库中，进行判断是第一次点赞还是取消之后再点赞
    Likes isExitDatabase(String customerId, String invitationId);

//  根据用户id查询这个用户之前点过赞的帖子
    List<Likes> getAllInvitationIdByCustomerId(String customerId);


//  判断当前帖子和用户的点赞关系
    LikesVO isLike(String customerId, String invitationId);

    //根据帖子id获取这个帖子的点赞数
    Integer getAllLikesCountsByInvitationId(String invitationId);

//    删除
    boolean delLike(Likes likes);

    List<Likes> getAllLikes();
    /**
     * 定时器使用，向数据库中新增数据
     * @param likes
     */
    void updateDatabseInfo(Likes likes);

    /**
     * 获取某用户收获的点赞数
     */
    int getLikesCountsByInvitationIdList(List<String> InvitationIdList);
}