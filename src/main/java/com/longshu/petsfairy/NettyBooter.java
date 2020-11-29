package com.longshu.petsfairy;

import com.longshu.petsfairy.netty.WBSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author :龙叔
 * @description:    监听springboot，当springboot启动完毕，判断当前事件是否为null，为空启动
 * @date :2019/11/28 9:49
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null){
            try {
                //启动websocket服务器
                WBSServer.getInstance().start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
