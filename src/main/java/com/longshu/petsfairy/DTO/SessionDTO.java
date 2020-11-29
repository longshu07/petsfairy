package com.longshu.petsfairy.DTO;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @descrption: openId和sessionKey
 */
@Data
public class SessionDTO {
    private String openid;

    //指定反序列化的字符串名称
    @JSONField(name = "session_key")
    private String sessionKey;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}