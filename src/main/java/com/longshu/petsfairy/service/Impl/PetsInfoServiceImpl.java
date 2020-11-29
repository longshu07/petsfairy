package com.longshu.petsfairy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.common.utils.pageHelper.PageUtils;
import com.longshu.petsfairy.dao.PetsInfoMapper;
import com.longshu.petsfairy.entity.PetsInfo;
import com.longshu.petsfairy.entity.PetsInfoExample;
import com.longshu.petsfairy.service.PetsInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PetsInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-05 14:42:17
 */
@Service("petsInfoService")
public class PetsInfoServiceImpl implements PetsInfoService {
    @Resource
    private PetsInfoMapper petsInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param petsInfoId 主键
     * @return 实例对象
     */
    @Override
    public PetsInfo queryById(String petsInfoId) {
        return petsInfoDao.selectByPrimaryKey(petsInfoId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PetsInfo> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param petsInfo 实例对象
     * @return 实例对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PetsInfo insert(PetsInfo petsInfo) {
        this.petsInfoDao.insertSelective(petsInfo);
        return petsInfo;
    }

    /**
     * 修改数据
     *
     * @param petsInfo 实例对象
     * @return 实例对象
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PetsInfo update(PetsInfo petsInfo) {
        int flag = this.petsInfoDao.updateByPrimaryKeySelective(petsInfo);
        if (flag == 0){
            return null;
        }
        return this.queryById(petsInfo.getPetsInfoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param petsInfoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String petsInfoId) {
        return this.petsInfoDao.deleteByPrimaryKey(petsInfoId) > 0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PageResult getAllPetsInfo(PageRequest pageRequest) {
        int pageSize = pageRequest.getPageSize();
        int pageNum = pageRequest.getPageNum();
        PageHelper.startPage(pageNum, pageSize);
        List<PetsInfo>  petsInfoList = petsInfoDao.selectByExample(null);
        PageInfo pageInfo = new PageInfo<>(petsInfoList);


        return PageUtils.getPageResult(pageInfo);
    }

    /**
     * 通过宠物种类id获取该种类下面的全部宠物信息，只需要正式中文名字、图片
     * @param categoryId
     * @return
     */
    @Override
    public List<PetsInfo> getPetInfoByPetCategoryId(String categoryId) {
        PetsInfoExample petsInfoExample = new PetsInfoExample();
        petsInfoExample.createCriteria().andCategoryIdEqualTo(categoryId);
        List<PetsInfo> petsInfoList = petsInfoDao.selectByExample(petsInfoExample);
        return petsInfoList;
    }
}