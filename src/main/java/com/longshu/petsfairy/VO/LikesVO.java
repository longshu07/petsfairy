package com.longshu.petsfairy.VO;

import lombok.Data;

/**
 * @author :龙叔
 * @description: 点赞状态和点赞数
 * @date :2020/4/16 17:33
 */
@Data
public class LikesVO {
//  ture为点赞，false为取消点赞
    Boolean isLikes;
//  这个帖子的点赞数
    Integer invitationLikesCounts;

    public LikesVO() {

    }

    public LikesVO(Boolean isLikes, Integer invitationLikesCounts) {
        this.isLikes = isLikes;
        this.invitationLikesCounts = invitationLikesCounts;
    }
}
