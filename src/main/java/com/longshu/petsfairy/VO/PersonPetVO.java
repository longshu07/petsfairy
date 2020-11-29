package com.longshu.petsfairy.VO;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author :龙叔
 * @description:  视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来。
 *              用户添加个人宠物的视图对象
 * @date :2020/4/7 18:15
 */
@Data
public class PersonPetVO {
//    id
    private String petId;
//昵称
    private String petName;
//  照片
    private String petPhoto;
//  性别，0 MM， 1GG，2未知
    private Integer petGender;
    //种类，填的是名称，种类唯一
    private String petVariety;
//  接收的字符串格式的日期
    private String petBirthday;
    //  接收的字符串格式的日期
    private String petComeDatetime;
//  绝育状态，0 已绝育， 1未绝育，2未知
    private Integer petSterilization;
//宠物主人的id
    private String petMasterId;
//  宠物重量
    private Double petWeight;
//宠物来到这个软件的登记时间 接收的字符串格式的日期
    private String petComePetsfairy;

}
