package com.longshu.petsfairy.controller;

import com.longshu.petsfairy.common.MyEnum.ResultEnum;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.PetCategory;
import com.longshu.petsfairy.service.PetCategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PetCategory)表控制层
 *
 * @author makejava
 * @since 2020-04-05 14:37:21
 */
@RestController
@RequestMapping("petCategory")
public class PetCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private PetCategoryService petCategoryService;
    @Resource
    private Sid sid;

    /**
     * 通过主键查询单条数据
     *
     * @param petCategoryId 主键
     * @return 单条数据
     */
    @ApiOperation(value="通过主键查询单条数据", notes="通过主键查询数据")
    @ApiImplicitParam(name = "petCategoryId", value = "petCategoryId", required = true, dataType = "String")
    @GetMapping("selectOne")
    public PetCategory selectOne(String petCategoryId) {
        return this.petCategoryService.queryById(petCategoryId);
    }


    /**
     * 通过宠物种类对象新增宠物种类
     * @param petCategory
     * @return
     */
    @ApiOperation(value="新增宠物种类", notes="新增宠物种类")
    @ApiImplicitParam(name = "petCategory", value = "petCategory", required = true, dataType = "PetCategory")
    @PostMapping("addPetsCategory")
    public Result addPetsCategory(@RequestBody PetCategory petCategory){
        if (petCategory == null || petCategory.getName() == null){
            return ResultUtil.dataNull();
        }
//      设置种类id
        petCategory.setCategoryId(sid.nextShort());

        petCategory = petCategoryService.insert(petCategory);
        if (petCategory == null){
            return ResultUtil.error("新增失败");
        }
        return ResultUtil.success(petCategory);
    }

    /**
     * 修改宠物种类
     * @param petCategory
     * @return
     */
    @ApiOperation(value="修改宠物种类", notes="修改宠物种类")
    @ApiImplicitParam(name = "petCategory", value = "petCategory", required = true, dataType = "PetCategory")
    @PostMapping("updateCategory")
    public Result updateCategory(@RequestBody PetCategory petCategory){
        if (petCategory.getCategoryId() == null){
            return ResultUtil.error("主键不存在");
        }
        if (petCategory == null || StringUtils.isEmpty(petCategory.getName())){
            return ResultUtil.dataNull();
        }

        petCategory = petCategoryService.update(petCategory);
        if (petCategory == null){
            return ResultUtil.error("修改失败");
        }
        return ResultUtil.success(petCategory);
    }

    @ApiOperation(value = "获取全部宠物种类信息")
    @ApiImplicitParam(name = "pageRequest", value = "pageRequest", required = true, dataType = "PageRequest")
    @PostMapping("getAllCategory")
    public Result getAllCategory(@RequestBody PageRequest pageRequest){
        PageResult pageResult =  petCategoryService.getAllCategory(pageRequest);
        return ResultUtil.success(pageResult);
    }

    @ApiOperation(value = "通过宠物种类编号删除宠物种类")
    @ApiImplicitParam(name = "petCategoryId", value = "petCategoryId", required = true, dataType = "String")
    @PostMapping("deleteCategory")
    public Result deleteCategory(String petCategoryId){
        Boolean flag = petCategoryService.deleteById(petCategoryId);
        return flag? ResultUtil.success("删除成功") : ResultUtil.error(ResultEnum.DEL_ERROR);
    }
}