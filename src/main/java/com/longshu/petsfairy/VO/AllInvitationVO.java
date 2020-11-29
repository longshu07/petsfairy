package com.longshu.petsfairy.VO;

import lombok.Data;

/**
 * @author :龙叔
 * @description:接收前端发来的分页查询帖子VO类
 * @date :2020/3/26 12:12
 */
@Data
public class AllInvitationVO {
    private int pageNum;//: this.refreshing ? 1 : this.fetchPageNum,
    private int pageSize;//: 20,
    private int status;// 1,
    private String orderStr;//: 'addtime',
    private String appidStr;//:'xybapp',
    private String token;//: this.token,
    private String shebei;//: util.shebei
    private String currentCustomerId;//当前登录用户的id

}
