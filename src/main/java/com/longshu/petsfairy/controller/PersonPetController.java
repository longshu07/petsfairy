package com.longshu.petsfairy.controller;

import com.github.pagehelper.PageInfo;
import com.longshu.petsfairy.DTO.InvitaionDTO;
import com.longshu.petsfairy.VO.PersonPetVO;
import com.longshu.petsfairy.common.MyEnum.ResultEnum;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.InvitaionToInvitaonDTO;
import com.longshu.petsfairy.common.utils.Result;
import com.longshu.petsfairy.common.utils.ResultUtil;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.common.utils.pageHelper.PageUtils;
import com.longshu.petsfairy.entity.Invitation;
import com.longshu.petsfairy.entity.PersonPet;
import com.longshu.petsfairy.service.InvitationService;
import com.longshu.petsfairy.service.PersonPetService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :龙叔
 * @description:
 * @date :2020/3/22 15:03
 */
@RestController
@RequestMapping("/personPet")
@Slf4j
public class PersonPetController {

    @Autowired
    private Sid sid;

    @Autowired
    private PersonPetService personPetService;

    @Autowired
    private InvitationService invitationService;


    @GetMapping("getPersonPetByPersonPetId")
    @ApiOperation(value="通过个人宠物id查询这个宠物的具体信息", notes="通过个人宠物id查询这个宠物的具体信息")
    public Result getPersonPetByPersonPetId(String personPetId){
        if(StringUtils.isEmpty(personPetId)){
            return ResultUtil.dataNull();
        }
        PersonPet personPet = personPetService.getPersonPetByPersonPetId(personPetId);
//      返回给前端的VO
        PersonPetVO personPetVOResult = new PersonPetVO();
//      将相同数据拷贝
        BeanUtils.copyProperties(personPet,personPetVOResult);
//      分别设置生日日期、变成String类型
        personPetVOResult.setPetBirthday(dateToString(personPet.getPetBirthday()));
        if (personPet.getPetComeDatetime() != null){
            personPetVOResult.setPetComeDatetime(dateToString(personPet.getPetComeDatetime()));
        }
        personPetVOResult.setPetComePetsfairy(dateToString(personPet.getPetComePetsfairy()));
        return ResultUtil.success(personPetVOResult);

    }

    /**
     * 通过个人宠物id查询这个宠物发的帖子，需要图片，文字就行
     * @param personPetId
     * @param pageNum
     * @param PageSize
     * @return
     */
    @GetMapping("getInvitationByPersonPetId")
    @ApiOperation(value="通过个人宠物id查询这个宠物发的帖子，需要图片，文字就行", notes="通过个人宠物id查询这个宠物发的帖子，需要图片，文字就行")
    public Result getInvitationByPersonPetId(String personPetId, Integer pageNum, Integer PageSize){
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(pageNum);
        pageRequest.setPageSize(PageSize);
        PageInfo pageInfo = invitationService.getInvitationByPersonPetId(personPetId, pageRequest);
//        返回给前端的数据
        List<InvitaionDTO> invitationDTOList = new ArrayList<>();
//        将service层的数据变成invitationDTO
        List<Invitation> invitationList = pageInfo.getList();
        if (invitationList != null){
            for (Invitation invitation : invitationList){
//                将时间变成时间戳，将图片变成list集合
                InvitaionDTO invitaionDTO = new InvitaionToInvitaonDTO().invitaionToInvitaonDTO(invitation);
//                将帖子内容存入
                invitaionDTO.setInvitationContent(invitation.getInvitationContent());
                invitationDTOList.add(invitaionDTO);
            }
        }
        pageInfo.setList(invitationDTOList);

        PageResult pageResult = PageUtils.getPageResult(pageInfo);
        return ResultUtil.success(pageResult);
    }


    /**
     * 添加个人宠物信息
     * 宠物信息，该用户id
     * @param personPetVO
     * @return
     */
    @PostMapping("/addPersonPetInfo")
    @ApiOperation(value="添加个人宠物信息", notes="添加个人宠物信息")
//    @ApiImplicitParam(name = "personPet", value = "personPet", required = true, dataType = "PersonPet")
    public Result addPersonPetInfo(@RequestBody PersonPetVO personPetVO){

        log.error("personPetVO: ", personPetVO);
        System.out.println(personPetVO);
        //用户id必须存在
        if (StringUtils.isEmpty(personPetVO.getPetMasterId())){
            return ResultUtil.error(ResultEnum.NOT_LOGIN.getCode(),ResultEnum.NOT_LOGIN.getMsg());
        }
        //必填数据必须存在
        if (StringUtils.isEmpty(personPetVO.getPetName()) ||
                StringUtils.isEmpty(personPetVO.getPetGender().toString()) ||
                StringUtils.isEmpty(personPetVO.getPetVariety()) ||
                StringUtils.isEmpty(personPetVO.getPetBirthday()) ||
                StringUtils.isEmpty(personPetVO.getPetSterilization().toString())){
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        PersonPet personPet = new PersonPet();
        BeanUtils.copyProperties(personPetVO,personPet);
        //将字符串变成data类型,设置宠物的生日
        personPet.setPetBirthday(stringToDate(personPetVO.getPetBirthday()));
        //当宠物到家日期存在时，写入数据库
        if (!StringUtils.isEmpty( personPetVO.getPetComeDatetime())){
            personPet.setPetComeDatetime(stringToDate(personPetVO.getPetComeDatetime()));
        }
        //创建个人宠物编号
        personPet.setPetId(sid.nextShort());
        //添加数据到数据库
        personPet = personPetService.addPersonPet(personPet);
        if (personPet == null){
            return ResultUtil.error(ResultEnum.ADD_ERROR.getCode(),ResultEnum.ADD_ERROR.getMsg());
        }
        return ResultUtil.success(personPet);
    }

    /**
     * 修改个人宠物信息，判断是否有个人宠物信息id传入
     * @param personPet
     * @return
     */
    @PostMapping("/updatePersonPetInfo")
    @ApiOperation(value="修改个人宠物信息，判断是否有个人宠物信息id传入", notes="修改个人宠物信息，判断是否有个人宠物信息id传入")
    @ApiImplicitParam(name = "personPet", value = "personPet", required = true, dataType = "PersonPet")
    public Result updatePersonPetInfo(@RequestBody PersonPet personPet){

        //用户id必须存在
        if (StringUtils.isEmpty(personPet.getPetMasterId())){
            return ResultUtil.error(ResultEnum.NOT_LOGIN.getCode(),ResultEnum.NOT_LOGIN.getMsg());
        }
        //判断是否有个人宠物信息id传入
        if (StringUtils.isEmpty(personPet.getPetId())){
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }

        personPet = personPetService.updatePersonPetInfo(personPet);

        return ResultUtil.success(personPet);
    }

    /**
     * 获取个人宠物信息
     * @param customerId
     * @return
     */
    @GetMapping("/getPersonPetInfo")
    @ApiOperation(value="获取个人宠物信息", notes="获取个人宠物信息")
    @ApiImplicitParam(name = "customerId", value = "customerId", required = true, dataType = "String")
    public Result getPersonPetInfo(String customerId){
        if (StringUtils.isEmpty(customerId)){
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
        }
        List<PersonPet> personPetList =  personPetService.getPersonPetInfo(customerId);
        return ResultUtil.success(personPetList);

    }

    /**
     * 根据个人宠物id删除
     * @param personPetId
     *
     * @return
     */
    @PostMapping("/deletePersonPet")
    @ApiOperation(value="删除个人宠物信息", notes="删除个人宠物信息")
    @ApiImplicitParam(name = "personPetId", value = "personPetId", required = true, dataType = "String")
    public Result deletePersonPet(String personPetId){
        if (StringUtils.isEmpty(personPetId)){
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg());
        }
        int flag = personPetService.deletePersonPet(personPetId);
        if (flag == 0){
            return ResultUtil.error(ResultEnum.DEL_ERROR.getCode(),ResultEnum.DEL_ERROR.getMsg());
        }
        return ResultUtil.success("删除成功");

    }

    //将字符串日期变成date类型
    private Date stringToDate(String dateString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

//  将date类型变成字符串
    private String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(date);
        return dateString;
    }

}
