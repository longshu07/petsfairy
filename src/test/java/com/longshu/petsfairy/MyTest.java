//package com.longshu.petsfairy;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.data.redis.core.RedisTemplate;
//
///**
// * @author :龙叔
// * @description:
// * @date :2020/4/16 14:52
// */
//public class MyTest {
//  @Test
//    public void redisDemo() {
//      ApplicationContext context =
//              new ClassPathXmlApplicationContext("application.properties");
//      RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
//
//      //将user对象存储到redis缓存中
//      redisTemplate.opsForValue().set("user_1", "a");
//      redisTemplate.opsForValue().set("sunhui", "helloworld");
//  }
//}