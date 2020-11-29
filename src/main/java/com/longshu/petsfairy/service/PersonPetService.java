package com.longshu.petsfairy.service;

import com.longshu.petsfairy.entity.PersonPet;

import java.util.List;

/**
 * 个人宠物
 */
public interface PersonPetService {
    //添加个人宠物信息
    PersonPet addPersonPet(PersonPet personPet);

    //修改个人宠物信息
    PersonPet updatePersonPetInfo(PersonPet personPet);
    //获取个人宠物信息
    List<PersonPet> getPersonPetInfo(String customerId);

    //删除个人宠物信息
    int deletePersonPet(String personPetId);
//  通过个人宠物id获取宠物信息
    PersonPet getPersonPetByPersonPetId(String personPetId);
}
