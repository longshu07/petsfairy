package com.longshu.petsfairy.service;

import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.PetCategory;
import java.util.List;

/**
 * (PetCategory)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 14:37:16
 */
public interface PetCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    PetCategory queryById(String categoryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PetCategory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param petCategory 实例对象
     * @return 实例对象
     */
    PetCategory insert(PetCategory petCategory);

    /**
     * 修改数据
     *
     * @param petCategory 实例对象
     * @return 实例对象
     */
    PetCategory update(PetCategory petCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    boolean deleteById(String categoryId);

    PageResult getAllCategory(PageRequest pageRequest);
}