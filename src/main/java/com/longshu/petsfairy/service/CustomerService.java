package com.longshu.petsfairy.service;

import com.longshu.petsfairy.entity.Customer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCusInfo();

    //新增用户
    Customer insertSelective(Customer user);

    //通过用户id查询用户信息
    Customer getUserInfoByCusId(String cusId);

    //修改用户个人信息
    Customer updateUserInfo(Customer customer);


}
