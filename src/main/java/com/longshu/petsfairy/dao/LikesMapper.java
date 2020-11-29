package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.Likes;
import com.longshu.petsfairy.entity.LikesExample;
import com.longshu.petsfairy.entity.LikesKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikesMapper {
    int countByExample(LikesExample example);

    int deleteByExample(LikesExample example);

    int deleteByPrimaryKey(LikesKey key);

    int insert(Likes record);

    int insertSelective(Likes record);

    List<Likes> selectByExample(LikesExample example);

    Likes selectByPrimaryKey(LikesKey key);

    int updateByExampleSelective(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByExample(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);
}