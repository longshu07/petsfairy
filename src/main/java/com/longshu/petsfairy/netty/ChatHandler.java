package com.longshu.petsfairy.netty;
import com.alibaba.fastjson.JSON;
import com.longshu.petsfairy.SpringUtil;
import com.longshu.petsfairy.entity.Comment;
import com.longshu.petsfairy.entity.Customer;
import com.longshu.petsfairy.entity.ReplyPush;
import com.longshu.petsfairy.service.CommentService;
import com.longshu.petsfairy.service.CustomerService;
import com.longshu.petsfairy.service.InvitationService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author :龙叔
 * @description:    创建自定义助手类
 *                  TextWebSocketFrame，在netty中是用来处理文本对象的，frame是消息的载体
 *                  这里已经指定了类型 如果这里是Object 那么下面还需判断是不是TextWebSocketFrame类型
 * @date :2019/11/28 9:33
 */

public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //评论服务类
//    @Resource
//    private CommentService commentService;


    //创建一个默认的channelGroup，管理全部的客户channel
    private static ChannelGroup client = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

        //獲取评论逻辑类
        CommentService commentService = (CommentService) SpringUtil.getBean("commentServiceImpl");
        //獲取用户逻辑类
        CustomerService customerService = (CustomerService) SpringUtil.getBean("customerServiceImpl");
        //獲取帖子逻辑类
        InvitationService invitationService = (InvitationService) SpringUtil.getBean("invitationServiceImpl");
        /**
         * 1,获取客户端发来的消息
         * 2 判断消息类型，根据不同的类型来处理不同的业务
         *  2.1 当websocket第一次open时，初始化channel，把用的channel和userId关联起来
         *  2.2聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态【未签收】
         *  2.3签收消息类型，针对具体的消息进行签收，修改数据库只能对应消息的签收状态【已经签收】
         *  2.4心跳类型的消息
         */

        //获取客户端发来的消息
        String content = textWebSocketFrame.text();
        if (StringUtils.isEmpty(content)){
            return;
        }
        System.out.println(content);
        //获取当前的channel
        Channel currentChannel = channelHandlerContext.channel();
//        CommentPush commentPush = new CommentPush();
        //将收到的消息变成对象
        DataContent dataContent = JSON.parseObject(content,DataContent.class);
        System.out.println(dataContent.toString());
        CommentPush commentPush = dataContent.getCommentPush();

        //将当前登录用户的id和channel连接在一起
        UserChannelRel.put(commentPush.getCommentSelfId(), currentChannel);
//       查看当前的channel
        UserChannelRel.outPut();
        /**第一次连接，查询其是否有未读的消息，
         * commentSelfId=,这个存第一次登录之后用户的id
         * 1、通过用户id查询帖子id，通过id查询其未读取的消息
         * 2、通过replyCommentId，查询是否有人对其进行回复
         * 将1和查询出来的消息整合一起返回给前端
         * 返回情况
         * xxx评论了你 content， 通过点击这个，进入到帖子详情界面，即需要返回帖子id，评论人，评论内容，评论时间
        */
        //当websocket第一次open时，初始化channel，在前端刚open时调用一次发送，把用的channel和userId关联起来，并且从数据库中获取没有签收的消息
         if (dataContent.getAction() == 0){

            List<ReplyPush> unReadCommentList = commentService.setCommentPush(commentPush.getCommentSelfId());
            if (!unReadCommentList.isEmpty()){
                //当前用户id
                String userId = commentPush.getCommentSelfId();
                //将当前登录用户的id和channel连接在一起
                UserChannelRel.put(userId, currentChannel);

                //创建返回对象
                DataContent returnDataContent = new DataContent();
                CommentPush returnCommentPush = new CommentPush();
                //获取每一条评论的评论id，组合list
                List<String> commentIdList = new ArrayList<>();
                //将查询出来的需要推送的消息进行整合
                for (ReplyPush replyPush : unReadCommentList){
                    //将id整合到list集合中
                    commentIdList.add(replyPush.getCommentId());
                    //先将属性复制到returnCommentPush
                    BeanUtils.copyProperties(replyPush,returnCommentPush);
//                如果不等于none,说明这个是回复，目前灭有帖子id，要获取其帖子id
                    if(!"NONE".equals(returnCommentPush.getReplyCommentId())){
                        //通过查找这里的帖子id即评论id找到其帖子id，并设置
                        String invitationId = commentService.getInvitationIdByCommentId(returnCommentPush.getInvitationId());
                        returnCommentPush.setInvitationId(invitationId);
                        System.out.println("NONE" + returnCommentPush.getNickname());

                    }else {
                        //其他的情况说明是评论，有帖子id，用户信息，通过评论人id获取用户信息
                        Customer customer = customerService.getUserInfoByCusId(returnCommentPush.getCommentSelfId());
                        returnCommentPush.setNickname(customer.getNickname());
                        System.out.println("customer.getNickname():" + customer.getNickname());
                        returnCommentPush.setAvatarurl(customer.getAvatarurl());
                    }
                    returnDataContent.setCommentPush(returnCommentPush);
                    returnDataContent.setAction(0);
                    returnDataContent.setExtand(null);
                    currentChannel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(returnDataContent)));
                }
                //更新已被推送消息
                commentService.updatePushComment(commentIdList);

            }

        }else if (dataContent.getAction() == 1) {
             //前端存到数据成功之后，调用发送信息功能，从数据库中获取消息，
             //说明是发表评论，这时需要查找被评论的用户是否在线 commentSelfId 评论人 commentReply被评论人
             //commentPush 里面有评论用户头像和昵称、齐全了
             //判断被评论人是否在线
             Channel receiveChannel = UserChannelRel.getChannel(commentPush.getReplyCommentId());
            //receiverChannel不为空，在全局channel管理中查找这channel是否存在,不在线就不用管，数据已经存入数据库中了
             System.out.println("查看receiveChannel:" + receiveChannel);
             if (receiveChannel != null){
                 System.out.println("查看receiveChannelID:" + receiveChannel.id());
                 Channel channelFind = client.find(receiveChannel.id());

                 if (channelFind != null) {
                     System.out.println("查看channelFindId:" + channelFind.id());
                     //当前用户在线，，发送消息
                     //创建返回对象
                     DataContent returnDataContent = new DataContent();

                     returnDataContent.setAction(1);
                     returnDataContent.setCommentPush(commentPush);
                     returnDataContent.setExtand(null);
                     receiveChannel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(returnDataContent)));
                     //发送完毕，更新对象消息
                     Comment comment = new Comment();
                     comment.setCommentId(commentPush.getCommentId());
                     comment.setPushState(1);
                     commentService.updateComment(comment);
                 }
             }

         }
//        /**
//         *
//         * TODO:有个bug，换行会报错，无法换行
//         * */
//        //将传递过来的数据变成消息接收实体类
//        System.out.println("content" + content);
//        DataContent dataContent = JsonUtils.jsonToPojo(content, DataContent.class);
//
//        //获取传递过来的消息类型
//        Integer action = dataContent.getAction();
//
//        //当websocket第一次open时，初始化channel，在前端刚open时调用一次发送，把用的channel和userId关联起来，并且从数据库中获取没有签收的消息
//        if (action == MsgActionEnum.CONNECT.type){
//            //当前用户id
//            Integer userId = dataContent.getChatMsg().getSenderId();
//            //将当前登录用户的id和channel连接在一起
//            UserChannelRel.put(dataContent.getChatMsg().getSenderId(), currentChannel);
//            //获取没有签收的数据了
//            //从数据库中签收没有签收的消息
////            //获取service
//            ChatMsgService chatMsgService = (ChatMsgService) SpringUtil.getBean("chatMsgServiceImpl");
//            //通过当前用户的id来去数据库中通过接收者的id来查询没有签收的数据
//            List<com.four.shopshow.entity.ChatMsg> chatMsgUnsignList = chatMsgService.getAllUnsignMsgByUserId(userId);
//            List<String> chatMsgUnsignIdList = new ArrayList<>();
//            if (chatMsgUnsignList != null && chatMsgUnsignList.size() > 0){
//                for (com.four.shopshow.entity.ChatMsg chatMsg : chatMsgUnsignList){
//                    //获取灭有签收的id
//                    chatMsgUnsignIdList.add(chatMsg.getId());
//
//                    DataContent dataContent1 = new DataContent();
//                    ChatMsg chatMsgNetty = new ChatMsg();
//                    chatMsgNetty.setMsg(chatMsg.getMsg());
//                    chatMsgNetty.setMsgId(chatMsg.getId());
//                    chatMsgNetty.setSenderId(chatMsg.getSendUserId());
//                    chatMsgNetty.setReceiverId(chatMsg.getAcceptUserId());
//                    chatMsgNetty.setCreateTime(chatMsg.getCreateTime());
//                    dataContent1.setChatMsg(chatMsgNetty);
//                    currentChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(dataContent1)));
//                }
//
//                //全部签收，标记已读发送
//                if (chatMsgUnsignIdList != null && chatMsgUnsignIdList.size() > 0){
//                    chatMsgService.updataMsgSigned(chatMsgUnsignIdList);
//                }
//            }
//
//
//
//        }else if(action == MsgActionEnum.CHAT.type){
//
//            //根据角色对多人发送消息，//单独对一个人发送推送消息
//            /**
//             * 单独发送消息的话，这个角色字段设置为null
//             *
//             * dataContent有一个role的类型，
//             * 这个类型放置String，通过逗号，分割其角色名称
//             * 这里接收到角色名称后将其分割，通过角色名称查找userId
//             * 将每一个userId变成接收方的id，加载到数据库中
//             */
//            //获取群发字段
//            String toAll = dataContent.getExtand();
//            //获取角色名称集合
//            String role = dataContent.getRole();
//            //角色字段为null，扩展字段为null 则单独发送
//            if (StringUtils.isEmpty(role) && StringUtils.isEmpty(toAll)){
//                //聊天型信息，保存到数据库，并标记签收状态
//                ChatMsg chatMsg =   dataContent.getChatMsg();
//                String contentText = chatMsg.getMsg();
//                Integer receiverId = chatMsg.getReceiverId();
//                Integer senderId = chatMsg.getSenderId();
//                //获取service
//                ChatMsgService chatMsgService = (ChatMsgService) SpringUtil.getBean("chatMsgServiceImpl");
////              从全局channel和User的关系中获取接收方的对应的channel
//                Channel receiverChannel = UserChannelRel.getChannel(receiverId);
//                if (receiverChannel == null){
//                    //当前用户没有上线，处于离线状态，将消息标记为  【未签收】
//
//                    chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                }else{
//
//                    //receiverChannel不为空，在全局channel管理中查找这channel是否存在
//                    Channel channelFind = client.find(receiverChannel.id());
//                    if (channelFind != null){
//                        //当前用户在线，  数据库中标记【已签收】直接显示发送
//                        String msgId = chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.SIGNED.type);
//                        //发送者保存msgId,发送过去， 接收者获取msgId就可以修改签状态
//                        chatMsg.setMsgId(msgId);
/////                   新建一个发送消息内容
//                        DataContent sentData = new DataContent();
//                        sentData.setChatMsg(chatMsg);
//                        //直接发送
//                        receiverChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(sentData)));
//                    }else {
//                        //当前用户断开连接了，处于离线状态 将消息标记为  【未签收】
//                        chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                    }
//
//                }
//                //群发消息,扩展字段为1，角色为null
//            }else if ("1".equals(toAll) && StringUtils.isEmpty(role)){
//                //聊天型信息
//                ChatMsg chatMsg = dataContent.getChatMsg();
//                //获取service
//                ChatMsgService chatMsgService = (ChatMsgService) SpringUtil.getBean("chatMsgServiceImpl");
//                //查询全部用户id，除了发送用户自己
//                //获取发送者id
//                Integer senderId = dataContent.getChatMsg().getSenderId();
//                //获取全部的用户
//                List<Integer> allUserList = chatMsgService.getAllReceiverIdExeptSender(senderId);
//
//                //查找这个接收者是否在线
//                for (Integer singleReceiverId : allUserList) {
//                    //通过接受者id查找channel是否在线不在线，保存数据到数据库
//                    if (UserChannelRel.getChannel(singleReceiverId) == null) {
//                        //设置推送消息的接收者
//                        chatMsg.setReceiverId(singleReceiverId);
//
//                        chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                    } else {
//                        //查找这个接收者是在在线
//                        Channel receiverChannel = UserChannelRel.getChannel(singleReceiverId);
//                        //receiverChannel不为空，在全局channel管理中查找这channel是否存在
//                        Channel channelFind = client.find(receiverChannel.id());
//
//                        if (channelFind != null) {
//                            chatMsg.setReceiverId(singleReceiverId);
//                            //当前用户在线，  数据库中标记【已签收】直接显示发送
//                            String msgId = chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.SIGNED.type);
//                            //发送者保存msgId,发送过去， 接收者获取msgId就可以修改签状态
//                            chatMsg.setMsgId(msgId);
//                            //新建一个发送消息内容
//                            DataContent sentData = new DataContent();
//                            sentData.setChatMsg(chatMsg);
//                            //直接发送
//                            receiverChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(sentData)));
//                        } else {
//                            //当前用户断开连接了，处于离线状态 将消息标记为  【未签收】
//                            chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                            //设置推送消息的接收者
//                            chatMsg.setReceiverId(singleReceiverId);
//                            chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                        }
//
//
//                    }
//                }
//
//
//            } else if (!StringUtils.isEmpty(role) && StringUtils.isEmpty(toAll)){
//                //角色字段不为null，extand为null
//
//                //聊天型信息
//                ChatMsg chatMsg = dataContent.getChatMsg();
//                //获取service
//                ChatMsgService chatMsgService = (ChatMsgService) SpringUtil.getBean("chatMsgServiceImpl");
//                /**
//                 * dataContent有一个role的类型，
//                 * 这个类型放置String，通过逗号，分割其角色名称
//                 * 这里接收到角色名称后将其分割，通过角色名称查找userId
//                 * 将每一个userId变成接收方的id，加载到数据库中
//                 */
//                //切割角色名称
//                String[] roles = role.split(",");
//                // 通过角色名称查询用户id
//                Set<Integer> receiverIdSet = chatMsgService.getAllReceiverIdByRoleName(roles);
//
//                //查找这个接收者是否在线
//                for (Integer singleReceiverId : receiverIdSet){
//                    //通过接受者id查找channel是否在线不在线，保存数据到数据库
//                    if (UserChannelRel.getChannel(singleReceiverId) == null){
//                        //设置推送消息的接收者
//                        chatMsg.setReceiverId(singleReceiverId);
//
//                        chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                    }else {
//                        //查找这个接收者是在在线
//                        Channel receiverChannel = UserChannelRel.getChannel(singleReceiverId);
//                        //receiverChannel不为空，在全局channel管理中查找这channel是否存在
//                        Channel channelFind = client.find(receiverChannel.id());
//
//                        if (channelFind != null){
//                            chatMsg.setReceiverId(singleReceiverId);
//                            //当前用户在线，  数据库中标记【已签收】直接显示发送
//                            String msgId = chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.SIGNED.type);
//                            //发送者保存msgId,发送过去， 接收者获取msgId就可以修改签状态
//                            chatMsg.setMsgId(msgId);
//                            //新建一个发送消息内容
//                            DataContent sentData = new DataContent();
//                            sentData.setChatMsg(chatMsg);
//                            //直接发送
//                            receiverChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(sentData)));
//                        }else {
//                            //当前用户断开连接了，处于离线状态 将消息标记为  【未签收】
//                            chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                            //设置推送消息的接收者
//                            chatMsg.setReceiverId(singleReceiverId);
//                            chatMsgService.addChatMsg(chatMsg, MsgSignFlagEnum.UNSIGN.type);
//                        }
//
//
//                    }
//
//                }
//            }
//
//
//        }

    }


//        //获取客户端发来的信息
//        String content = textWebSocketFrame.text();
//        System.out.println("接收到的信息为：" + content);
//
//        client.writeAndFlush(new TextWebSocketFrame("我是服务器，我接受到你的消息为" + content));


    /**
     * 当客户端连接服务端之后（打开连接）
     * 获取客户端的channle，并且放到ChannelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        client.add(ctx.channel());
    }

    /**
     * // 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel,所以下面的remove不用我们再手写
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        client.remove(ctx.channel());
        System.out.println("客户端断开，channel对应的长ID为：" + ctx.channel().id().asLongText());
        System.out.println("客户端断开，channel对应的短ID为：" + ctx.channel().id().asShortText());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        client.add(ctx.channel());
        System.out.println("连接成功");
    }

}
