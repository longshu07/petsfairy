package com.longshu.petsfairy.service;

import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.Follow;
import java.util.List;

/**
 * (Follow)表服务接口
 *
 * @author makejava
 * @since 2020-04-13 17:53:35
 */
public interface FollowService {

    /**
     * 新增数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    Follow insert(Follow follow);

    /**
     * 取消关注
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    Boolean cancelFollow(Follow follow);


    /**
     * 获取该用户全部关注的人
     * @param beConcernedCustomerId
     * @return
     */
    PageResult getAllBeConcernedByCurrentCusId(String beConcernedCustomerId,Integer pageNum, Integer pageSize);

    /**
     * 获取该用户的粉丝信息
     * @param followCustomerId
     * @return
     */
    PageResult getAllFansByFollowCusId(String followCustomerId, Integer pageNum, Integer pageSize);

    /**
     * 获取该用户的关注数
     * @param currentCustomerId
     * @return
     */
    Integer getAllBeConcernedCounts(String currentCustomerId);

    /**
     * 获取该用户的粉丝数
     * @param currentCustomerId
     * @return
     */
    Integer getAllFansCounts(String currentCustomerId);

    /**
     * 判断这个用户是否当前用户的关注对象
     * @param follow
     * @return
     */
    Boolean isFollow(Follow follow);

    Boolean updatelFollow(Follow follow);

    /**
     * 判断这个两个用户是否存在于当前数据库表
     * @param follow
     * @return
     */
    Follow isFollowDatabase(Follow follow);
}