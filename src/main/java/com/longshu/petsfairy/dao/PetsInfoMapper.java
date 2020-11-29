package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.PetsInfo;
import com.longshu.petsfairy.entity.PetsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetsInfoMapper {
    int countByExample(PetsInfoExample example);

    int deleteByExample(PetsInfoExample example);

    int deleteByPrimaryKey(String petsInfoId);

    int insert(PetsInfo record);

    int insertSelective(PetsInfo record);

    List<PetsInfo> selectByExample(PetsInfoExample example);

    PetsInfo selectByPrimaryKey(String petsInfoId);

    int updateByExampleSelective(@Param("record") PetsInfo record, @Param("example") PetsInfoExample example);

    int updateByExample(@Param("record") PetsInfo record, @Param("example") PetsInfoExample example);

    int updateByPrimaryKeySelective(PetsInfo record);

    int updateByPrimaryKey(PetsInfo record);
}