package com.longshu.petsfairy.service.Impl;

import com.longshu.petsfairy.dao.PersonPetMapper;
import com.longshu.petsfairy.entity.PersonPet;
import com.longshu.petsfairy.entity.PersonPetExample;
import com.longshu.petsfairy.service.PersonPetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description:个人宠物逻辑层
 * @date :2020/3/22 11:38
 */
@Service
public class PersonPetServiceImpl implements PersonPetService {
    @Resource
    private PersonPetMapper personPetMapper;

    /**
     * 添加个人宠物信息
     * @param personPet
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PersonPet addPersonPet(PersonPet personPet) {
        personPet.setPetComePetsfairy(new Date());
        int flag = personPetMapper.insert(personPet);
        if (flag == 0){
            return null;
        }
        return personPet;
    }

    /**
     * 修改个人宠物信息
     * @param personPet
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PersonPet updatePersonPetInfo(PersonPet personPet) {
        int flag = personPetMapper.updateByPrimaryKeySelective(personPet);
        if (flag == 0){
            return null;
        }
        return personPet;
    }

    /**
     * 查找个人宠物的信息
     * @param customerId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<PersonPet> getPersonPetInfo(String customerId) {
        PersonPetExample personPetExample = new PersonPetExample();
        personPetExample.createCriteria().andPetMasterIdEqualTo(customerId);
        List<PersonPet> personPetList =  personPetMapper.selectByExample(personPetExample);
        return personPetList;
    }

    /**
     * 删除个人宠物信息
     * @param personPetId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int deletePersonPet(String personPetId) {
        int flag = personPetMapper.deleteByPrimaryKey(personPetId);
        return flag;
    }

    /**
     * 通过个人宠物id获取宠物信息
     * @param personPetId
     * @return
     */
    @Override
    public PersonPet getPersonPetByPersonPetId(String personPetId) {
        return personPetMapper.selectByPrimaryKey(personPetId);
    }
}
