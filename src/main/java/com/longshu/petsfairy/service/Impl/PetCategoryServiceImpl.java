package com.longshu.petsfairy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.common.utils.pageHelper.PageUtils;
import com.longshu.petsfairy.dao.PetCategoryMapper;
import com.longshu.petsfairy.entity.PetCategory;
import com.longshu.petsfairy.service.PetCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PetCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-04-05 14:37:17
 */
@Service("petCategoryService")
public class PetCategoryServiceImpl implements PetCategoryService {
    @Resource
    private PetCategoryMapper petCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    @Override
    public PetCategory queryById(String categoryId) {
        PetCategory petCategory = petCategoryDao.selectByPrimaryKey(categoryId);
        return petCategory;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PetCategory> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param petCategory 实例对象
     * @return 实例对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PetCategory insert(PetCategory petCategory) {
        int flag = petCategoryDao.insertSelective(petCategory);
        if (flag == 0){
            return null;
        }
        return petCategory;
    }

    /**
     * 修改数据
     *
     * @param petCategory 实例对象
     * @return 实例对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PetCategory update(PetCategory petCategory) {
        int flag = petCategoryDao.updateByPrimaryKeySelective(petCategory);
        if (flag == 0){
            return null;
        }
        return queryById(petCategory.getCategoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteById(String categoryId) {
        return this.petCategoryDao.deleteByPrimaryKey(categoryId) > 0;
    }

    /**
     * 分页获取全部的宠物种类
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult getAllCategory(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();

        //关键代码是 PageHelper.startPage(pageNum, pageSize)，将前台分页查询参数传入并拦截MyBtis执行实现分页效果。
        PageHelper.startPage(pageNum, pageSize);
        List<PetCategory> petCategoryList = petCategoryDao.selectByExample(null);
        PageInfo pageInfo = new PageInfo<>(petCategoryList);
        return PageUtils.getPageResult(pageInfo);
    }
}