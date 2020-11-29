package com.longshu.petsfairy.controller;

import com.longshu.petsfairy.VO.FansAndBeConcernedCounts;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.Customer;
import com.longshu.petsfairy.entity.Follow;
import com.longshu.petsfairy.service.CustomerService;
import com.longshu.petsfairy.service.FollowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 关注(Follow)表控制层
 * 1、查看当前用户的粉丝数
 * 2、查看当前用户的关注数
 * 3、查看当前用户的粉丝的个人信息（通过
 * 4、查看当前用户关注的个人信息
 * 5、添加关注（需要两个人的id
 *6、取消关注（同上
 *
 * @author makejava
 * @since 2020-04-13 17:53:35
 */
@RestController
@RequestMapping("follow")
public class FollowController {
    /**
     * 服务对象
     */
    @Resource
    private FollowService followService;

    @Resource
    private Sid sid;

    @Resource
    private CustomerService customerService;

    @ApiOperation(value="判断这两两个用户是否关注", notes="判断这两两个用户是否关注")
    @PostMapping("isFollow")
    public Result isFollow(@RequestBody Follow follow){
        if (StringUtils.isEmpty((follow.getCustomerId())) || StringUtils.isEmpty(follow.getFollowedCustomer())){
            return ResultUtil.dataNull();
        }
        Boolean isFollowFlag = followService.isFollow(follow);


        return ResultUtil.success(isFollowFlag);
    }




    /**
     * 添加关注关注
     * 传递两个id，然后去数据库中查询，发现是否存在，如果存在，则判断其关注状态，如果是0，则变成1，如果是一，则变成0
     *                              如果不存在，则新增，并且为关注状态
     * @param follow
     * @return
     */
    @ApiOperation(value="添加或取消关注", notes="添加或取消关注")
    @PostMapping("addOrCancelFollow")
    public Result addOrCancelFollow(@RequestBody Follow follow){
        if (StringUtils.isEmpty((follow.getCustomerId())) || StringUtils.isEmpty(follow.getFollowedCustomer())){
            return ResultUtil.dataNull();
        }
        follow.setFollowId(null);
//        判断当前两个用户id是否存在关系（即，是否存在于数据库中） null 不存在
        Follow isFollowStaus = followService.isFollowDatabase(follow);
        if (isFollowStaus == null){
//            不存在，需要新增，其变成关注状态
            follow.setFollowId(sid.nextShort());
//        1代表关注
            follow.setStatus(1);
//        关注成功，
            followService.insert(follow);
            return ResultUtil.success("成功关注",true);
        }
//      如果当前两个用户存在关系，即在数据库中
        if (isFollowStaus.getStatus().equals(1)){
            isFollowStaus.setStatus(0);
            followService.updatelFollow(isFollowStaus);
            return ResultUtil.success("取消关注",false);
        }
        isFollowStaus.setStatus(1);
        followService.updatelFollow(isFollowStaus);
        return ResultUtil.success("成功关注",true);

//
    }

    @ApiOperation(value="取消关注", notes="取消关注")
    @PostMapping("delFollow")
    public Result delFollow(@RequestBody Follow follow){
        if (StringUtils.isEmpty((follow.getCustomerId())) || StringUtils.isEmpty(follow.getFollowedCustomer())){
            return ResultUtil.dataNull();
        }
//        0代表取消关注
        follow.setStatus(0);
//        取消关注成功，返回当前用户的全部关注对象？
        Boolean cancelFlag = followService.cancelFollow(follow);
        if (!cancelFlag){
            return ResultUtil.error("取消失败");
        }
        return ResultUtil.success("取消关注");
    }

    /**
     * 获取该用户全部关注的人
     * @param beConcernedCustomerId
     * @return
     */
    @ApiOperation(value="获取该用户全部关注的人", notes="获取该用户全部关注的人")
    @PostMapping("getAllBeConcerned")
    public Result getAllBeConcernedByCurrentCusId(String beConcernedCustomerId,Integer pageNum, Integer pageSize){
        if (StringUtils.isEmpty(beConcernedCustomerId)){
            return ResultUtil.dataNull();
        }
        PageResult pageResult = followService.getAllBeConcernedByCurrentCusId(beConcernedCustomerId,pageNum,pageSize);
//        获取其中的关注表中的信息
        List<Follow> followList = (List<Follow>) pageResult.getContent();
        List<Customer> customerList = new ArrayList<>();
//        遍历关注表，获取这个被关注的，查询其个人信息
        for (Follow follow : followList){
            Customer customer =  customerService.getUserInfoByCusId(follow.getFollowedCustomer());
            customerList.add(customer);
        }
        pageResult.setContent(customerList);
        return ResultUtil.success(pageResult);
    }

    /**
     * 获取该用户的粉丝
     * @param followCustomerId
     * @return 返回这些粉丝的用户信息，包括 头像、用户id、昵称、性别
     */
    @ApiOperation(value="获取该用户的粉丝", notes="获取该用户的粉丝")
    @PostMapping("getAllFansByCurrentCusId")
    public Result getAllFansByFollowCusId(String followCustomerId, Integer pageNum, Integer pageSize){
        if (StringUtils.isEmpty(followCustomerId)){
            return ResultUtil.dataNull();
        }
        PageResult pageResult = followService.getAllFansByFollowCusId(followCustomerId,pageNum,pageSize);
//        获取其中的关注表中的信息
        List<Follow> followList = (List<Follow>) pageResult.getContent();
//        返回给前端的粉丝的个人信息
        List<Customer> customerList = new ArrayList<>();
//        遍历关注表，获取这个粉丝的id，查询其个人信息
        for (Follow follow : followList){
            Customer customer =  customerService.getUserInfoByCusId(follow.getCustomerId());
            customerList.add(customer);
        }
        pageResult.setContent(customerList);
        return ResultUtil.success(pageResult);
    }

    @ApiOperation(value="获取该用户的粉丝数和关注数量", notes="获取该用户的粉丝数和关注数量")
    @GetMapping("getAllFansAndBeConcernedCounts")
    public Result getAllFansAndBeConcernedCounts(String currentCustomerId){
        if (StringUtils.isEmpty(currentCustomerId)){
            return ResultUtil.dataNull();
        }
        FansAndBeConcernedCounts  fansAndBeConcernedCounts = new FansAndBeConcernedCounts();
        fansAndBeConcernedCounts.setBeConcernedCounts( followService.getAllBeConcernedCounts(currentCustomerId));
        fansAndBeConcernedCounts.setFansCounts(followService.getAllFansCounts(currentCustomerId));
        return ResultUtil.success(fansAndBeConcernedCounts);
    }

    private List<Customer> followInfoToCustoerInfo(List<Follow> followList){
//        返回给前端的粉丝的个人信息
        List<Customer> customerList = new ArrayList<>();
//        遍历关注表，获取这个粉丝的id，查询其个人信息
        for (Follow follow : followList){
            Customer customer =  customerService.getUserInfoByCusId(follow.getCustomerId());
            customerList.add(customer);
        }
        return customerList;
    }

}