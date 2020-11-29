package com.longshu.petsfairy.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @author :龙叔
 * @description: 服务端websocket服务器
 * @date :2019/11/28 8:40
 */
@Component
public class WBSServer {

    private EventLoopGroup mainGroup;//主线程,负责接收客户端连接
    private EventLoopGroup subGroup;//从线程，负责IO处理工作
    private ServerBootstrap serverBootstrap;//服务器启动类，辅助工具类，用于服务通道的一系列配置
    private ChannelFuture channelFuture;

    public WBSServer(){
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(mainGroup,subGroup)//绑定两个线程
                .channel(NioServerSocketChannel.class)//指定IO模式
                .childHandler(new WBSServerInititialzer());//④子处理器，处理工作线程（从线程）

    }

    //WBSServer是单例，写一个静态内部类来获取单例
    private static class SingletionWBSServer{
        static final WBSServer instance = new WBSServer();

    }

    //获取WBSServer的实例
    public static WBSServer getInstance(){
        return SingletionWBSServer.instance;
    }

    //启动方法
    public void start(){

        this.channelFuture = serverBootstrap.bind(8090);
        System.out.println("netty websocket server 启动完毕....");
    }

}
