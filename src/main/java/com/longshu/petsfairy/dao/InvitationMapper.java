package com.longshu.petsfairy.dao;

import com.longshu.petsfairy.entity.Invitation;
import com.longshu.petsfairy.entity.InvitationExample;
import com.longshu.petsfairy.entity.Likes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvitationMapper {
    int countByExample(InvitationExample example);

    int deleteByExample(InvitationExample example);

    int deleteByPrimaryKey(String invitationId);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    List<Invitation> selectByExample(InvitationExample example);

    Invitation selectByPrimaryKey(String invitationId);

    int updateByExampleSelective(@Param("record") Invitation record, @Param("example") InvitationExample example);

    int updateByExample(@Param("record") Invitation record, @Param("example") InvitationExample example);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);

    /**
     * 分页查询全部帖子
     */
    List<Invitation> selectAllInvitaionByPage();

    /**
     * 获取某个用户点过赞的全部帖子
     * @return
     */
    List<Invitation> getAllBeLikedInvitationByCustomerId(String customerId);

    /**
     *  通过帖子List查询帖子数据
     * @param invitationIdsBeLike
     * @return
     */
    List<Invitation> getAllBeLikedInvitationByInvitationList(List<Likes> invitationIdsBeLike);
}