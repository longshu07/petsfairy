package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.PersonPet;
import com.longshu.petsfairy.entity.PersonPetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonPetMapper {
    int countByExample(PersonPetExample example);

    int deleteByExample(PersonPetExample example);

    int deleteByPrimaryKey(String petId);

    int insert(PersonPet record);

    int insertSelective(PersonPet record);

    List<PersonPet> selectByExample(PersonPetExample example);

    PersonPet selectByPrimaryKey(String petId);

    int updateByExampleSelective(@Param("record") PersonPet record, @Param("example") PersonPetExample example);

    int updateByExample(@Param("record") PersonPet record, @Param("example") PersonPetExample example);

    int updateByPrimaryKeySelective(PersonPet record);

    int updateByPrimaryKey(PersonPet record);
}