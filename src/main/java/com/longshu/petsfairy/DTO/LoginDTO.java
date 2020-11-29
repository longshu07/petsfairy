package com.longshu.petsfairy.DTO;


import lombok.Data;

/**
 * rawData:{
 * "nickName": "小匠",
 * "gender": 1,
 * "language": "zh_CN",
 * "city": "北京",
 * "province": "北京",
 * "country": "CN",
 * "avatarUrl": "http://wx.qlogo.cn/mmopen/vi_32/1vZvI39NWFQ9XM4LtQpFrQJ1xlgZxx3w7bQxKARol6503Iuswjjn6nIGBiaycAjAtpujxyzYsrztuuICqIM5ibXQ/0"
 * }
 */
@Data
public class LoginDTO {
    // 用户信息原始数据
    private String rawData;

    // 用于验证用户信息是否被篡改过
    private String signature;

    // 用户获取 session_key 的 code
    private String code;

    private String shebei;

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShebei() {
        return shebei;
    }

    public void setShebei(String shebei) {
        this.shebei = shebei;
    }
}
