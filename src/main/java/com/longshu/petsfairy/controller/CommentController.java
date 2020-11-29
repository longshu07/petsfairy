package com.longshu.petsfairy.controller;

import com.longshu.petsfairy.DTO.CommentDTO;
import com.longshu.petsfairy.VO.CommentRequestVO;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.Comment;
import com.longshu.petsfairy.entity.Customer;
import com.longshu.petsfairy.service.CommentService;
import com.longshu.petsfairy.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description: 评论控制
 * @date :2020/3/29 15:14
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    //id生成类
    @Resource
    private Sid sid;

    @Resource
    private CustomerService customerService;

    /**
     * 新增评论
     * @param commentRequestVO,
     * @return 返回的是评论，不包括评论中的回复
     */
    @PostMapping("/addComment")
    @ApiOperation(value="新增评论", notes="新增评论")
    @ApiImplicitParam(name = "commentRequestVO", value = "commentRequestVO", required = true, dataType = "CommentRequestVO")
    public Result addComment(@RequestBody CommentRequestVO commentRequestVO){
        //设置id
        commentRequestVO.setCommentId(sid.nextShort());
        //将VO内容复制出来
        Comment comment = new Comment();
        PageRequest pageRequest = new PageRequest();
        //将属于评论表中的信息复制到评论表中
        BeanUtils.copyProperties(commentRequestVO,comment);
        BeanUtils.copyProperties(commentRequestVO, pageRequest);
        comment.setCreateTime(new Date());
        //加入数据库
        PageResult pageResult = commentService.addComment(comment, pageRequest);
        return ResultUtil.success(comment);
    }

//    @PostMapping("/addReply")
//    @ApiOperation(value="新增回复", notes="新增回复")
//    @ApiImplicitParam(name = "commentRequestVO", value = "commentRequestVO", required = true, dataType = "CommentRequestVO")
//    public Result addReply(@RequestBody CommentRequestVO commentRequestVO){
//        //设置id
//        commentRequestVO.setCommentId(sid.nextShort());
//        //将VO内容复制出来
//        Comment comment = new Comment();
//        PageRequest pageRequest = new PageRequest();
//        //将属于评论表中的信息复制到评论表中
//        BeanUtils.copyProperties(commentRequestVO,comment);
//        BeanUtils.copyProperties(commentRequestVO, pageRequest);
//        //加入数据库
//        PageResult pageResult = commentService.addComment(comment, pageRequest);
//        return ResultUtil.success(pageResult);
//    }

    /**
     * 删除评论，还需要将该评论下来的回复一并删除
     * @param commentRequestVO
     * @return
     */
    @PostMapping("/delComment")
    @ApiOperation(value="删除评论，删除完毕之后返回整个帖子下面的最新评论", notes="删除评论，删除完毕之后返回整个帖子下面的最新评论")
    @ApiImplicitParam(name = "commentRequestVO", value = "commentRequestVO", required = true, dataType = "CommentRequestVO")
    public Result delComment(@RequestBody CommentRequestVO commentRequestVO){
        //将VO内容复制出来
        Comment comment = new Comment();

        //将属于评论表中的信息复制到评论表中
        BeanUtils.copyProperties(commentRequestVO,comment);

        Boolean delFlag = commentService.delComment(comment);
        return delFlag? ResultUtil.success("删除成功") : ResultUtil.success("删除失败");
    }

    /**
     * 获取某个帖子下面的全部的评论消息，并且分页处理
     * 并且将评论下来的回复一并在其中
     * @param
     * @return
     */
    @PostMapping("getAllCommentByInvitationId")
    @ApiOperation(value="获取某个帖子下面的全部的评论消息，并且分页处理", notes="获取某个帖子下面的全部的评论消息，并且分页处理")
    public Result getAllCommentByInvitationId(@RequestBody CommentRequestVO commentRequestVO){
        //将VO内容复制出
        PageRequest pageRequest = new PageRequest();
        //将属于page需要的参数copy出来
        BeanUtils.copyProperties(commentRequestVO, pageRequest);

        PageResult pageResult = commentService.getAllComments(pageRequest, commentRequestVO.getInvitationId());

        //获取在pageInfo中的原始对象,即评论的对象集合
        List<Comment> commentList = (List<Comment>) pageResult.getContent();
        //resultList替代commentList集合
        List<CommentDTO> resultList = new ArrayList<>();
        for (Comment comment : commentList){
            //返回给前端的评论数据对象
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);

            // 查询评论人的个人信息
            Customer customerComent = customerService.getUserInfoByCusId(comment.getCommentSelfId());
            commentDTO.setCustomer(customerComent);

            //查询这个帖子下面的评论数量
            Integer commentCounts = commentService.findCommentCountsByInvitationId(comment.getInvitationId());
            commentDTO.setCounts(commentCounts);

            //将date类型的时间变成毫秒值存入
            commentDTO.setCreateTime(comment.getCreateTime().getTime());

            //将这里评论id在回复属性中查询，查询是否有回复信息集合
            List<Comment> replyCommentList = commentService.selectReplyByReplyCommentId(comment.getCommentId());

            //如果有回复的评论，还需要将回复的信息转换成带有回复人的个人信息（头像，名称，是否关注）
            List<CommentDTO> replyCommentDTOList = new ArrayList<>();
            if (!replyCommentList.isEmpty()){

               for (Comment replyComment : replyCommentList){
                   //返回给前端的回复数据对象
                   CommentDTO commentReplyDTO = new CommentDTO();
                   BeanUtils.copyProperties(replyComment,commentReplyDTO);
                   //查询回复人的个人信息
                   Customer customerReply = customerService.getUserInfoByCusId(replyComment.getCommentSelfId());
                   //设置这个回复人的个人信息
                   commentReplyDTO.setCustomer(customerReply);
                   //将回复信息迁移到返回给前端的集合中
                   replyCommentDTOList.add(commentReplyDTO);
               }
            }
            commentDTO.setCommentReplyList(replyCommentDTOList);
            resultList.add(commentDTO);
        }
        pageResult.setContent(resultList);
        return ResultUtil.success(pageResult);
    }

    /**
     *
     */
    @GetMapping("selectReplyPush")
    @ApiOperation(value="推送查询 查询还未被推送的评论消息", notes="推送查询 查询还未被推送的评论消息")
    public Result selectReplyPush(String customerId){
        return ResultUtil.success(commentService.setCommentPush(customerId));
    }
}
