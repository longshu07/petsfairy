package com.longshu.petsfairy.controller;


import com.longshu.petsfairy.entity.Girl;
import com.longshu.petsfairy.service.GilrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author :龙叔
 * @description:
 * @date :2019/11/7 10:47
 */
@RestController
@RequestMapping("/test")
public class GirlController {

    @Resource
    private GilrService gilrService;

//    @Resource
//    private SelfUserDetailsService orderService;
    @ApiOperation(value = "所有店铺十二个月的销量数据",notes = "传年份以及，后台返回所有店铺十二个月的销量数据")
    @GetMapping("/getUser")
    public Girl getUser(String text) {
    System.out.println(text);
        Girl user =  gilrService.getUser();
        return user;
    }


    /**
     * 简单注册功能
     * @param username
     * @param password
     * @return
     */
//    public Map<String, Object> login(String username, String password){
//        orderService.loadUserByUsername(username,password);
//
//    }
//    @PostMapping("/register")
//    public Map<String, Object> register(String username, String password){
//        orderService.register(username,password);
//        return ResultVO.result(ResultEnum.SUCCESS,true);
//    }
}
