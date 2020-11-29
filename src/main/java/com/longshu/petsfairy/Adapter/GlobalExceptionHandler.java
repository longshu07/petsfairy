package com.longshu.petsfairy.Adapter;

/**
 * @author :龙叔
 * @description ： 异常全局管理类
 * @date :2020/3/16 11:53
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public Result processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        /**
         * 未知异常
         */
        log.error("错误信息看这里 [○･｀Д´･ ○]",ex);

        return ResultUtil.error(500, ex.toString(),ex.toString().substring(0,47));

        //        if (ex instanceof MissingServletRequestParameterException) {
//            return  ResultUtil.error(400, ex.toString());
//        }
//        if (ex instanceof NoPermissions) {
//
//            LOGGER.error("=======" + ex.getMessage() + "=======");
//            return new ResponseResult(401, "sorry，无权限！");
//
//        }
//
//        if (ex instanceof DuplicateKeyException) {
//            LOGGER.error("=======违反主键约束：主键重复插入=======");
//            return new ResponseResult(400, "主键重复插入！");
//        }


    }

}