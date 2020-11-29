package com.longshu.petsfairy.common.MyEnum;

/**
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @author 张瑶
 * @date 2018/4/19 09:42
 */
public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    USER_NOT_EXIST(1,"用户不存在"),
    USER_IS_EXISTS(2,"用户已存在"),
    DATA_IS_NULL(3,"有数据未填"),
    NAME_IS_EXIT(4,"名字已存在"),
    REGITS_EXIT(5,"已注册过会员"),
    NOT_LOGIN(6, "用户没有登录"),
    ADD_ERROR(7, "新增失败"),
    DEL_ERROR(8, "删除失败"),
    PHOTO_ERROR(9,"图片上传异常"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}