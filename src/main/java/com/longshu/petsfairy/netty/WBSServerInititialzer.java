package com.longshu.petsfairy.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author :龙叔
 * @description:    子处理器，负责子线程的一些工作
 * @date :2019/11/28 9:03
 */
public class WBSServerInititialzer  extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //定义一个ChannelPipLine，每一个channel由多个handler共同组成一个管道（pipLine)
        ChannelPipeline channelPipeline = socketChannel.pipeline();

        //websocket基于http协议，所有都需要http编码解码器
        channelPipeline.addLast(new HttpServerCodec());
        // 对写大数据流的支持
        channelPipeline.addLast(new ChunkedWriteHandler());

        /*
          我们通常接收到的是一个http片段，如果要想完整接受一次请求的所有数据，我们需要绑定HttpObjectAggregator，然后我们
         *就可以收到一个FullHttpRequest-是一个完整的请求信息。
         *对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
         *几乎在netty中的编程，都会使用到此hanler
         */
        channelPipeline.addLast(new HttpObjectAggregator(1024 * 64));


        /**
         * websocket服务器处理协议,用于指定给客户端连接访问的路由：/ws
         *对应本websocket来讲，都是以frame进行传输，不同的数据类型对应的frame也不同
         */
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //      自定义handler
        channelPipeline.addLast(new ChatHandler());
        //============================  自定义handler给工作线程完成  ==========================================

    }
}
