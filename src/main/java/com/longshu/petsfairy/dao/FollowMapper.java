package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.Follow;
import com.longshu.petsfairy.entity.FollowExample;
import com.longshu.petsfairy.entity.FollowKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowMapper {
    int countByExample(FollowExample example);

    int deleteByExample(FollowExample example);

    int deleteByPrimaryKey(FollowKey key);

    int insert(Follow record);

    int insertSelective(Follow record);

    List<Follow> selectByExample(FollowExample example);

    Follow selectByPrimaryKey(FollowKey key);

    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);
}