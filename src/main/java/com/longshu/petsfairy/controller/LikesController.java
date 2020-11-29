package com.longshu.petsfairy.controller;

import com.longshu.petsfairy.VO.LikesVO;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.RedisUtils;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.Invitation;
import com.longshu.petsfairy.entity.Likes;
import com.longshu.petsfairy.service.InvitationService;
import com.longshu.petsfairy.service.LikesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * (Likes)表控制层
 *
 * @author makejava
 * @since 2020-04-16 16:36:40
 */
@RestController
@RequestMapping("likes")
public class LikesController {
    /**
     * 服务对象
     */
    @Resource
    private LikesService likesService;

    @Resource
    private InvitationService invitationService;

    @Resource
    private Sid sid;
//  注入redis工具类
    @Resource
    RedisUtils redisUtils;

    //增加或取消赞,同时需要返回这个帖子的点赞数
    @ApiOperation(value="增加或取消赞", notes="增加或取消赞")
    @PostMapping("addOrCancelLikes")
    public Result addOrCancelLikes(@RequestBody Likes likes){
        if (StringUtils.isEmpty(likes.getCustomerId()) || StringUtils.isEmpty(likes.getInvitationId())){
            return ResultUtil.dataNull();
        }
        LikesVO likesVO = new LikesVO();
//        先判断这个like是否存在于数据库中
        Likes likesIsExitDatabaseFlag = likesService.isExitDatabase(likes.getCustomerId(), likes.getInvitationId());
//       不为空，存在，则update,要更新数据，likesisExitDatabaseFlag中点赞的状态
        if (likesIsExitDatabaseFlag != null){
//          原本是点赞状态，则取消 0
            if (1 == likesIsExitDatabaseFlag.getIsDelete()){
                likes.setIsDelete(0);
                likesService.updateLikes(likes);
                likesVO.setIsLikes(false);


            }else {
//                原本是取消点赞状态，则点赞 1
                likes.setIsDelete(1);
                likesService.updateLikes(likes);
                likesVO.setIsLikes(true);

            }
        }else {
//            不存在，新增
            likes.setIsDelete(1);
            likes.setCreatetime(new Date());
            likesService.insertLike(likes);
            likesVO.setIsLikes(true);
        }
        Integer likeCounts = likesService.getAllLikesCountsByInvitationId(likes.getInvitationId());
        likesVO.setInvitationLikesCounts(likeCounts);
        return ResultUtil.success(likesVO);
    }


    //  获取这个帖子的点赞数
    @ApiOperation(value="获取这个帖子的点赞数", notes="获取这个帖子的点赞数")
    @GetMapping("getAllLikesCountsByInvitationId")
    public Result getAllLikesCountsByInvitationId(String invitationId){
        return ResultUtil.success(likesService.getAllLikesCountsByInvitationId(invitationId));
    }




    //    删除点赞数据
    @ApiOperation(value="删除点赞数据", notes="删除点赞数据")
    @PostMapping("delLike")
    public Result delLike(@RequestBody Likes likes){
        return ResultUtil.success(likesService.delLike(likes));
    }


    //  判断当前帖子和用户的点赞关系
    @ApiOperation(value="判断这两两个用户是否关注", notes="判断这两两个用户是否关注")
    @PostMapping("isLikes")
    public Result isLikes(@RequestBody Likes likes){
        if (StringUtils.isEmpty((likes.getCustomerId())) || StringUtils.isEmpty(likes.getInvitationId())){
            return ResultUtil.dataNull();
        }
        LikesVO isLikeVO = likesService.isLike(likes.getCustomerId(),likes.getInvitationId());
        return ResultUtil.success(isLikeVO);
    }

//    获取全部点赞表中的全部数据
    @ApiOperation(value="获取全部点赞表中的全部数据", notes="获取全部点赞表中的全部数据")
    @GetMapping("getAllLikes")
    public Result getAllLikes(){
        return ResultUtil.success(likesService.getAllLikes());
    }

    /**
     * 获取某用户收获的点赞数
     */
    @ApiOperation(value="获取某用户收获的点赞数", notes="获取某用户收获的点赞数")
    @GetMapping("getLikesCountsByCustomerId")
    public Result getLikesCountsByCustomerId(String customerId){
        PageRequest pageRequest = new PageRequest(0, 0);
        PageResult pageResult =invitationService.getInvitationByCustomerId(customerId,pageRequest);
        List<Invitation> invitationList = (List<Invitation>) pageResult.getContent();

        List<String> initationIdsList = new ArrayList<>();
        for (Invitation invitation : invitationList){
            initationIdsList.add(invitation.getInvitationId());
        }
        System.out.println("initationIdsList:" + initationIdsList);
        int likesCounts = likesService.getLikesCountsByInvitationIdList(initationIdsList);
        return ResultUtil.success(likesCounts);
    }

}