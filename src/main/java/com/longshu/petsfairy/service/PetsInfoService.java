package com.longshu.petsfairy.service;

import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.PetsInfo;

import java.util.List;

/**
 * (PetsInfo)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 14:42:17
 */
public interface PetsInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param petsInfoId 主键
     * @return 实例对象
     */
    PetsInfo queryById(String petsInfoId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PetsInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param petsInfo 实例对象
     * @return 实例对象
     */
    PetsInfo insert(PetsInfo petsInfo);

    /**
     * 修改数据
     *
     * @param petsInfo 实例对象
     * @return 实例对象
     */
    PetsInfo update(PetsInfo petsInfo);

    /**
     * 通过主键删除数据
     *
     * @param petsInfoId 主键
     * @return 是否成功
     */
    boolean deleteById(String petsInfoId);

    /**
     * 通过分页查询全部宠物信息
     * @param pageRequest
     * @return
     */
    PageResult getAllPetsInfo(PageRequest pageRequest);

    /**
     * 过宠物种类id获取该种类下面的全部宠物信息，只需要正式中文名字、图片
     * @param categoryId
     * @return
     */
    List<PetsInfo> getPetInfoByPetCategoryId(String categoryId);
}