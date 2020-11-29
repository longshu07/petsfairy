package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.PetCategory;
import com.longshu.petsfairy.entity.PetCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetCategoryMapper {
    int countByExample(PetCategoryExample example);

    int deleteByExample(PetCategoryExample example);

    int deleteByPrimaryKey(String categoryId);

    int insert(PetCategory record);

    int insertSelective(PetCategory record);

    List<PetCategory> selectByExample(PetCategoryExample example);

    PetCategory selectByPrimaryKey(String categoryId);

    int updateByExampleSelective(@Param("record") PetCategory record, @Param("example") PetCategoryExample example);

    int updateByExample(@Param("record") PetCategory record, @Param("example") PetCategoryExample example);

    int updateByPrimaryKeySelective(PetCategory record);

    int updateByPrimaryKey(PetCategory record);
}