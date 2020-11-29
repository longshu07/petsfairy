package com.longshu.petsfairy.common.utils;

import com.longshu.petsfairy.common.MyEnum.ResultEnum;

/**
 * @author :龙叔
 * @description: 返回接口的结果工具类
 * @date :2019/11/25 10:47
 */
public class ResultUtil {

    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**成功带数据以及返回msg**/
    public static Result success(String msg,Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result success(){

        return success(null);
    }
    /**失败**/
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**失败**/
    public static Result error(Integer code,String msg,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(Object object){
        Result result = new Result();
        result.setCode(500);
        result.setMsg("");
        result.setData(object);
        return result;
    }
    //数据为空
    public static Result dataNull(){
        Result result = new Result();
        result.setCode(ResultEnum.DATA_IS_NULL.getCode());
        result.setMsg(ResultEnum.DATA_IS_NULL.getMsg());
        return result;
    }
}