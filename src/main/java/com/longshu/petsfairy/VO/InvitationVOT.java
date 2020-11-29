package com.longshu.petsfairy.VO;

import lombok.Data;

/**
 * @author :龙叔
 * @description: PageinvitationVO
 * @date :2020/3/26 13:38
 */
@Data
public class InvitationVOT {
    private int number;//: this.refreshing ? 1 : this.fetchPageNum,
    private int size;//: 20,
}
