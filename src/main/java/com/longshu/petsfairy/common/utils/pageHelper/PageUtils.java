package com.longshu.petsfairy.common.utils.pageHelper;

import com.github.pagehelper.PageInfo;

/**
 * @author :龙叔
 * @description:分页查询相关工具类。
 * @date :2020/3/26 11:49
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
//      当前页
        pageResult.setPageNum(pageInfo.getPageNum());
//      当前页的数量
        pageResult.setPageSize(pageInfo.getPageSize());
//      总记录数
        pageResult.setTotalSize(pageInfo.getTotal());
//      总页数
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
