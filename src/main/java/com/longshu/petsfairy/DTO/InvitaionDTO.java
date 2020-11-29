package com.longshu.petsfairy.DTO;

import com.longshu.petsfairy.VO.LikesVO;
import com.longshu.petsfairy.entity.Customer;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description:返回给前端的帖子信息，将图片字符串变成数组
 *              时间变成时间戳
 *              有发帖人信息
 *              还需要帖子的评论数量，帖子的点赞数
 * @date :2020/3/25 13:51
 */
@Data
public class InvitaionDTO {
    private String invitationId;

    private String invitationContent;

    private List<String> photoList = new ArrayList<>();

    private long createTime;

    private String invitationMasterId;
//    这个帖子的是宠物发布的，将宠物id变成宠物名称
    private String personPetsId;
//    变成宠物名称
    private String personPetsNickname;
    //新增一个发帖人信息
    private Customer customer;
    //帖子评论数量
    private int commentCounts;
//    新增一个这个帖子是否和当前用户是关注关系
    private Boolean isFollow;

    private LikesVO likesVO;
}
