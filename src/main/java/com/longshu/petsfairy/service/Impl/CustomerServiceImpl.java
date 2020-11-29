package com.longshu.petsfairy.service.Impl;

import com.alibaba.fastjson.JSON;
import com.longshu.petsfairy.dao.CustomerMapper;
import com.longshu.petsfairy.entity.Customer;
import com.longshu.petsfairy.entity.CustomerExample;
import com.longshu.petsfairy.service.CustomerService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :龙叔
 * @description: 用户逻辑实现层
 * @date :2020/3/11 16:40
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Autowired
    private RedisTemplate<Object, Object> stringRedisTemplate;
    /**
     * 查询全部用户的信息
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Customer> getAllCusInfo(){
        List<Customer> customerList = customerMapper.selectByExample(null);
        return customerList;
    }

    /**
     * 新增用户
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Customer insertSelective(Customer user) {
//        stringRedisTemplate.opsForValue().set("test",user);
//        System.out.println("test::::::::" + stringRedisTemplate.opsForValue().get("test"));

        //如果该用户存在，更新用户的信息
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andOpenidEqualTo(user.getOpenid());

        List<Customer> resultList = customerMapper.selectByExample(customerExample);
        if (!resultList.isEmpty()){

            Customer customer = resultList.get(0);
            customer.setNickname(user.getNickname());
            customer.setGender(user.getGender());
            customer.setAvatarurl(user.getAvatarurl());
            customer.setToken(user.getToken());
            customer.setSessionKey(user.getSessionKey());
            customerMapper.updateByPrimaryKey(customer);
            return customer;
        }

        int flag = customerMapper.insertSelective(user);
        //插入失败，则为0，返回空值
        if (flag==0){
            return null;
        }
        //插入成功就放入缓存
//        stringRedisTemplate.opsForValue().set(user.getToken(),user);
        //这里是设置键的有效日期,不设置就是永久的token
//        stringRedisTemplate.expire(record.getToken(), 123L, TimeUnit.SECONDS);
        return user;

    }

    //通过用户id查询用户信息
    @Override
    public Customer getUserInfoByCusId(String cusId) {
        Customer customer = customerMapper.selectByPrimaryKey(cusId);
        if (customer != null){
            customer.setOpenid("");
        }

        return customer;
    }

    /**
     * 修改用户个人信息
     * @param customer
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Customer updateUserInfo(Customer customer) {
        int flag = customerMapper.updateByPrimaryKeySelective(customer);
        //插入失败，则为0，返回空值
        if (flag == 0){

            return null;
        }
        customer = customerMapper.selectByPrimaryKey(customer.getCustomerId());
        customer.setOpenid("");
        return customer;
    }
}
