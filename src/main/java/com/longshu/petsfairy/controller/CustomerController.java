package com.longshu.petsfairy.controller;

import com.alibaba.fastjson.JSON;
import com.longshu.petsfairy.Adapter.WechatAdapter;
import com.longshu.petsfairy.DTO.LoginDTO;
import com.longshu.petsfairy.DTO.ResultDTO;
import com.longshu.petsfairy.DTO.SessionDTO;
import com.longshu.petsfairy.DTO.TokenDTO;
import com.longshu.petsfairy.Error.CommonErrorCode;
import com.longshu.petsfairy.Error.ErrorCodeException;
import com.longshu.petsfairy.common.MyEnum.ResultEnum;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.DigestUtil;
import com.longshu.petsfairy.common.utils.RedisUtils;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.entity.Customer;
import com.longshu.petsfairy.entity.PersonPet;
import com.longshu.petsfairy.service.CustomerService;
import com.longshu.petsfairy.service.PersonPetService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author :龙叔
 * @description:用户控制类
 * @date :2020/3/11 16:50
 */
@RestController
@RequestMapping("/cusInfo")
@Slf4j
public class CustomerController {

    @Autowired
    private Sid sid;


    @Autowired
    private WechatAdapter wechatAdapter;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RedisUtils redisUtils;


    @ApiOperation(value="获取全部用户的信息", notes="获取全部用户的信息")
//    @ApiImplicitParam(name = "category", value = "种类", required = true, dataType = "Category")
    @GetMapping("/getAllCusInfo")
    public Result getAllCusInfo(){
        return ResultUtil.success(customerService.getAllCusInfo());
    }


    /*
    微信小程序登录
     */
    @PostMapping("/weixinLogin")
    @ApiOperation(value="登录微信小程序", notes="weixinLogin")
    public Result login(@RequestBody LoginDTO loginDTO){

        try{
            //获取openid和session_key
            SessionDTO sessionDTO = wechatAdapter.jscode2session(loginDTO.getCode());

//            //检验传过来的数据是否已被篡改
//             DigestUtil.checkDigest(loginDTO.getRawData(),sessionDTO.getSessionKey(),loginDTO.getSignature());
            //获取数据,头像，昵称，性别，
            Customer user = JSON.parseObject(loginDTO.getRawData(), Customer.class);

            //生成用户个人的token
            String token = UUID.randomUUID().toString();

            Date date = new Date();

            user.setToken(token);
            user.setCustomerId(sid.nextShort());
            user.setOpenid(sessionDTO.getOpenid());
            user.setSessionKey(sessionDTO.getSessionKey());

            //将user传到数据库中,返回已存入的user对象信息
            user = customerService.insertSelective(user);
            TokenDTO data = new TokenDTO();
            data.setToken(user.getToken());
            data.setOpenid(sessionDTO.getOpenid());

            return ResultUtil.success(user);
        }catch (ErrorCodeException e){

            return ResultUtil.error(1,e.getMessage());
        }catch (Exception e){
            e.printStackTrace();

            return ResultUtil.error(1,CommonErrorCode.UNKOWN_ERROR.getMessage());
        }
    }

    /**
     * 获取微信的accessToken
     */
    @GetMapping("/getAccessToken")
    public Result getAccessToken(){
        String accessToken = "";
//      判断key是否存在，true存在
        boolean hasKeyFlag = redisUtils.hasKey("accessToken");
        //不存在则获取
        if (!hasKeyFlag){
            accessToken = wechatAdapter.getAccessToken();
            //设置过期时间，并存入redis中,每过两个小时，这个AccessToken就过期了，如果用户需要用到这个AccessToken，就需要从新向微信开发接口获取
            redisUtils.set("accessToken",accessToken,7198);
        }else {
            accessToken = (String) redisUtils.get("accessToken");
        }
        return ResultUtil.success(accessToken);
    }

    /**
     * 每隔两小时获取一次token
     * @return
     */
//    @Scheduled(cron = "0 0 0 * * ?")
//    public Result getAccessTokenScheduled(){
//        String accessToken = wechatAdapter.getAccessToken();
//        return ResultUtil.success(accessToken);
//    }


    /**
     * 通过用户的id查询用户的个人信息
     * @param cusId
     * @return
     */
    @GetMapping("/getUserInfoByCusId")
    @ApiOperation(value="通过用户的id查询用户的个人信息", notes="通过用户的id查询用户的个人信息")
    @ApiImplicitParam(name = "cusId", value = "cusId", required = true, dataType = "String")
    public Result getUserInfoByCusId(String cusId){
        Customer customer = customerService.getUserInfoByCusId(cusId);
        return ResultUtil.success(customer);

    }

    /**
     * 修改用户个人信息
     * @param customer
     * @return
     */
    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "修改用户个人信息")
    @ApiImplicitParam(name = "customer", value = "customer", required = true, dataType = "Customer")
    public Result updateUserInfo(@RequestBody Customer customer){
        if (StringUtils.isEmpty(customer)){
            return ResultUtil.dataNull();
        }

         customer = customerService.updateUserInfo(customer);

        return ResultUtil.success(customer);
    }





}
