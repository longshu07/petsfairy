package com.longshu.petsfairy.controller;

import com.longshu.petsfairy.VO.PetsInfoVO;
import com.longshu.petsfairy.common.MyEnum.ResultEnum;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.PetsInfo;
import com.longshu.petsfairy.service.PetsInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (PetsInfo)表控制层
 *
 * @author makejava
 * @since 2020-04-05 14:42:17
 */
@Slf4j
@RestController
@RequestMapping("petsInfo")
public class PetsInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PetsInfoService petsInfoService;

    @Resource
    private Sid sid;


    /**
     * 通过宠物种类id获取该种类下面的全部宠物信息，只需要正式中文名字、图片
     * 因为中文名称是唯一的可以根据这个插入到个人宠物信息中
     * @param categoryId
     * @return
     */
    @ApiOperation(value = "通过宠物种类id获取该种类下面的全部宠物信息", notes = "通过宠物种类id获取该种类下面的全部宠物信息")
    @GetMapping("getPetInfoByPetCategoryId")
    public Result getPetInfoByPetCategoryId(String categoryId){
        List<PetsInfo> petsInfoList = petsInfoService.getPetInfoByPetCategoryId(categoryId);
        if (petsInfoList.size() == 0){
            return ResultUtil.error("种类下面无宠物");
        }
        List<PetsInfoVO> petsInfoVOListResult = new ArrayList<>();
        for (PetsInfo petsInfo : petsInfoList){
            PetsInfoVO petsInfoVO = new PetsInfoVO();
            BeanUtils.copyProperties(petsInfo, petsInfoVO);
            String[] photoList = petsInfo.getPetsPhotos().split(",");
//        将帖子类中的图片字符串变成数组，并且将数据转移
            for (String photo : photoList){
                petsInfoVO.getPetsPhotosList().add(photo);
            }
            petsInfoVOListResult.add(petsInfoVO);

        }

        return ResultUtil.success(petsInfoVOListResult);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param petsInfoId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result selectOne(String petsInfoId) {
        return ResultUtil.success(this.petsInfoService.queryById(petsInfoId));
    }

    /**
     * 新增宠物信息
     * @param petsInfo
     * @return
     */
    @PostMapping("addPetsInfo")
    @ApiOperation(value = "新增宠物信息")
    @ApiImplicitParam(name = "petsInfo", value = "petsInfo", required = true, dataType = "PetsInfo")
    public Result addPetsInfo(@RequestBody PetsInfo petsInfo){
        if (StringUtils.isEmpty(petsInfo.getPetsNameCn()) || StringUtils.isEmpty(petsInfo.getPetsNameEn())
        || StringUtils.isEmpty(petsInfo.getCategoryId())){
            return ResultUtil.error(ResultEnum.DATA_IS_NULL);
        }
        petsInfo.getDomesticateMethod().replace(new String(Character.toChars(10)),"/");
        log.warn("是否执行了到这了", petsInfo.toString());
        petsInfo.getCharacterTraits().replace(new String(Character.toChars(10)),"/");
        petsInfo.getDiet().replace(new String(Character.toChars(10)),"/");
        petsInfo.getDisease().replace(new String(Character.toChars(10)),"/");
        petsInfo.getFormCharacter().replace(new String(Character.toChars(10)),"/");
        petsInfo.getHistory().replace(new String(Character.toChars(10)),"/");
        petsInfo.getLifeHabit().replace(new String(Character.toChars(10)),"/");
        petsInfo.getStandard().replace(new String(Character.toChars(10)),"/");
        petsInfo.getTips().replace(new String(Character.toChars(10)),"/");

        petsInfo.setPetsInfoId(sid.nextShort());
        petsInfo = petsInfoService.insert(petsInfo);
        if (petsInfo == null){
            return ResultUtil.error(ResultEnum.ADD_ERROR);
        }
        return ResultUtil.success(petsInfo);
    }


    /**
     * 根据id删除宠物信息
     * @param petsInfoId
     * @return
     */
    @ApiOperation(value = "根据id删除宠物信息")
    @ApiImplicitParam(name = "petsInfoId", value = "petsInfoId", required = true, dataType = "String")
    @PostMapping("petsInfoId")
    public Result deletePetsInfo(String petsInfoId){
        Boolean flag = petsInfoService.deleteById(petsInfoId);
        return flag ? ResultUtil.success("删除成功") : ResultUtil.error(ResultEnum.DEL_ERROR);
    }

    @ApiOperation(value = "修改宠物信息")
    @ApiImplicitParam(name = "petsInfo", value = "petsInfo", required = true, dataType = "PetsInfo")
    @PostMapping("updatePetsInfo")
    public Result updatePetsInfo(@RequestBody PetsInfo petsInfo){
        if (StringUtils.isEmpty(petsInfo.getPetsInfoId())){
            return ResultUtil.error("Id不存在");
        }
        if (StringUtils.isEmpty(petsInfo.getPetsNameCn()) || StringUtils.isEmpty(petsInfo.getPetsNameEn())
                || StringUtils.isEmpty(petsInfo.getCategoryId())){
            return ResultUtil.error(ResultEnum.DATA_IS_NULL);
        }
        petsInfo = petsInfoService.update(petsInfo);
        if (petsInfo == null){
            return ResultUtil.error("修改失败");
        }
        return ResultUtil.success(petsInfo);

    }

    @ApiOperation(value = "分页查询全部宠物信息")
    @ApiImplicitParam(name = "pageRequest", value = "pageRequest", required = true, dataType = "PageRequest")
    @PostMapping("getAllPetsInfo")
    public Result getAllPetsInfo(@RequestBody PageRequest pageRequest){

        PageResult pageResult = petsInfoService.getAllPetsInfo(pageRequest);
        return ResultUtil.success(pageResult);
    }

}