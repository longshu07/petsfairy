package com.longshu.petsfairy.VO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :龙叔
 * @description:通过宠物种类id获取该种类下面的全部宠物信息，只需要正式中文名字、图片
 * @date :2020/4/9 14:52
 */
@Data
public class PetsInfoVO {
    private String petsInfoId;

    private String petsNameCn;
    private List<String> petsPhotosList = new ArrayList<>();
}
