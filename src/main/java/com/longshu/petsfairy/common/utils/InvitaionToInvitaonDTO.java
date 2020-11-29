package com.longshu.petsfairy.common.utils;

import com.longshu.petsfairy.DTO.InvitaionDTO;
import com.longshu.petsfairy.entity.Invitation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author :龙叔
 * @description:
 *                将帖子类中的图片字符串变成数组，并且将数据转移
 *                将时间变成时间戳，timestemp
 * @date :2020/3/25 13:54
 */
@Controller
public class InvitaionToInvitaonDTO {

    public InvitaionDTO invitaionToInvitaonDTO(Invitation invitation){

        InvitaionDTO invitaionDTO = new InvitaionDTO();
//      将相同属性的复制到DTO中
        BeanUtils.copyProperties(invitation,invitaionDTO);
        //将时间变成时间戳，timestemp
        invitaionDTO.setCreateTime(invitation.getCreateTime().getTime());

        String[] photoList = invitation.getInvitationPhoto().split(",");
//        将帖子类中的图片字符串变成数组，并且将数据转移
        for (String photo : photoList){
            invitaionDTO.getPhotoList().add(photo);
        }
        return invitaionDTO;
    }
    public static void main(String[] args){
//        System.out.println();
        InvitaionToInvitaonDTO invitaionToInvitaonDTO = new InvitaionToInvitaonDTO();

        Invitation invitation = new Invitation();
        invitation.setInvitationId("1");
        invitation.setInvitationPhoto("1,2,3,4,5,");
        invitation.setCreateTime(new Date());
        invitation.setInvitationContent("内容");
        invitation.setInvitationMasterId("222");
        InvitaionDTO invitaionDTO = invitaionToInvitaonDTO.invitaionToInvitaonDTO(invitation);
        System.out.println(invitaionDTO.toString());
    }
}
