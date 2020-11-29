package com.longshu.petsfairy.netty;


import io.netty.channel.Channel;

import java.util.HashMap;

/**
 * @author :龙叔
 * @description: 将用户id和channel关联起来
 * @date :2019/11/29 10:26
 */
public class UserChannelRel {
    private static HashMap<Object, Channel> manager =new HashMap<>();
    //加入map
    public static void put(Object senderId, Channel channel){
        manager.put(senderId, channel);
    }

    //获取channel
    public static Channel getChannel(Object senderId){
        return manager.get(senderId);
    }

    //打印测试
    public static void outPut(){
        for (HashMap.Entry<Object, Channel> entry : manager.entrySet()){
            System.out.println("userId:" + entry.getKey() + ", ChannelId:" + entry.getValue().id().asLongText());
        }
    }
}
