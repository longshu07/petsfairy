package com.longshu.petsfairy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.common.utils.pageHelper.PageUtils;
import com.longshu.petsfairy.dao.FollowMapper;
import com.longshu.petsfairy.entity.Follow;

import com.longshu.petsfairy.entity.FollowExample;
import com.longshu.petsfairy.service.FollowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Follow 关注表)表服务实现类
 *
 * @author makejava
 * @since 2020-04-13 17:53:35
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {
    @Resource
    private FollowMapper followDao;



    /**
     * 新增数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Follow insert(Follow follow) {

        this.followDao.insert(follow);
        return follow;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean updatelFollow(Follow follow) {
        System.out.println(follow.toString());
        int flag = followDao.updateByPrimaryKeySelective(follow);
        System.out.println(flag);
        return flag > 0 ? true : false;
    }

    /**
     *取消关注
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean cancelFollow(Follow follow) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andCustomerIdEqualTo(follow.getCustomerId());
        criteria.andFollowedCustomerEqualTo(follow.getFollowedCustomer());
        List<Follow> followList = followDao.selectByExample(followExample);

        if (followList.isEmpty()){
//            如果当前两个人不是已关注的情况
            return false;
        }
        follow =  followList.get(0);
//      设置为0，即取消关注
        follow.setStatus(0);
        int flag = followDao.updateByPrimaryKey(follow);
        return flag > 0 ? true : false;
    }
    /**
     * 获取该用户全部关注的人
     * CustomerId,是当前用户自己的id，他在这一列，说明他有关注的人
     * @param beConcernedCustomerId
     * @return
     */
    @Override
    public PageResult getAllBeConcernedByCurrentCusId(String beConcernedCustomerId,Integer pageNum, Integer pageSize) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andCustomerIdEqualTo(beConcernedCustomerId);
//      开始分页
        return startPage(pageNum,pageSize,followExample);
    }
    /**
     * 获取该用户的粉丝
     * followCustomerId 是被关注的属性，当前用户在这一列，说明他被关注了，从而获取他的粉丝
     * @param followCustomerId
     * @return
     */
    @Override
    public PageResult getAllFansByFollowCusId(String followCustomerId, Integer pageNum, Integer pageSize) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andFollowedCustomerEqualTo(followCustomerId);
//      开始分页
        return startPage(pageNum,pageSize,followExample);
    }
    /**
     * 获取该用户的关注数
     * @param currentCustomerId
     * @return
     */
    @Override
    public Integer getAllBeConcernedCounts(String currentCustomerId) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andCustomerIdEqualTo(currentCustomerId);
        return followDao.countByExample(followExample);
    }
    /**
     * 获取该用户的粉丝数
     * @param currentCustomerId
     * @return
     */
    @Override
    public Integer getAllFansCounts(String currentCustomerId) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andFollowedCustomerEqualTo(currentCustomerId);
        return followDao.countByExample(followExample);
    }

    /**
     * 判断这个用户是否当前用户的关注对象
     * @param follow
     * @return
     */
    @Override
    public Boolean isFollow(Follow follow) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andCustomerIdEqualTo(follow.getCustomerId());
        criteria.andFollowedCustomerEqualTo(follow.getFollowedCustomer());
        criteria.andStatusEqualTo(1);
        List<Follow> followList = followDao.selectByExample(followExample);
//        System.out.println(followList);
        return !followList.isEmpty();
    }
    /**
     * 判断这个两个用户是否存在于当前数据库表,不存在返回null,存在返回follow整个对象
     * @param follow
     * @return
     */
    @Override
    public Follow isFollowDatabase(Follow follow) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andFollowedCustomerEqualTo(follow.getFollowedCustomer());
        criteria.andCustomerIdEqualTo(follow.getCustomerId());
        List<Follow> followList = followDao.selectByExample(followExample);
//      为空则不存在，返回null
        if (followList.isEmpty()){
            return null;
        }
//      存在，返回整个对象
        return followList.get(0);
    }

    /**
     * 分页操作
     * @param pageNum
     * @param pageSize
     * @param followExample
     * @return 返回pageResult
     */
    private PageResult startPage(Integer pageNum, Integer pageSize, FollowExample followExample){
//        开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<Follow> followList =  followDao.selectByExample(followExample);
        PageInfo pageInfo = new PageInfo<>(followList);
        return PageUtils.getPageResult(pageInfo);
    }


}