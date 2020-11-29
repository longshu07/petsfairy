package com.longshu.petsfairy.DTO;

import lombok.Data;

@Data
public class TokenDTO {
    private String token;
    private String openid;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}