package com.longshu.petsfairy.VO;

import java.nio.Buffer;

/**
 * @author :龙叔
 * @description: 测试图片鉴黄接口的实体类
 * @date :2020/5/14 18:30
 */
public class Media {
        private String contentType;
        private Buffer buffer;
        public Media(String contentType, Buffer buffer){
            this.contentType = contentType;
            this.buffer = buffer;
        }
        public Media(){

        }

}
