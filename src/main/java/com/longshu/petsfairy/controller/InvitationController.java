package com.longshu.petsfairy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longshu.petsfairy.DTO.InvitaionDTO;
import com.longshu.petsfairy.VO.AllInvitationVO;
import com.longshu.petsfairy.VO.LikesVO;
import com.longshu.petsfairy.VO.Media;
import com.longshu.petsfairy.common.idworker.Sid;
import com.longshu.petsfairy.common.utils.*;
import com.longshu.petsfairy.common.utils.pageHelper.PageRequest;
import com.longshu.petsfairy.common.utils.pageHelper.PageResult;
import com.longshu.petsfairy.entity.*;
import com.longshu.petsfairy.service.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.List;

/**
 * @author :龙叔
 * @description: 帖子控制类
 * @date :2020/3/23 17:54
 */
@RestController
@RequestMapping("/invitaion")
@Slf4j
public class InvitationController {

    @Autowired
    private Sid sid;
    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private CustomerService customerService;

    //评论逻辑类
    @Autowired
    private CommentService commentService;

    @Resource
    private FollowService followService;

    @Resource
    private LikesService likesService;

    @Resource
    private PersonPetService personPetService;

    /**
     * 图片上传，返回图片的url
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @PostMapping("/picture")
    public Result uploadImg( String accessToken, HttpServletRequest request, HttpServletResponse response) throws Exception{
        Invitation invitation = new Invitation();
        String url = "";
        try {
            // 效率较高的文件上传器
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                HashMap<String, Object> res = new HashMap<String, Object>();
                //获取文件
                MultipartFile file = req.getFile(iterator.next());
                //校验图片
                Result<JSONObject> checkImgResult = checkImg(file, accessToken);
                Integer errCode =  (Integer)checkImgResult.getData().get("errcode");
                if ( 87014 == errCode){
                    return ResultUtil.error("图片涉嫌违规");
                }else if (0 != errCode){
                    log.error(checkImgResult.toString());
                    return ResultUtil.error("图片不符合要求");
                }
                //上传到fastDFS
                 url = fastDFSClient.uploadFile(file);
            }
        } catch (MaxUploadSizeExceededException e) {
            log.error("图片上传异常", e);
            return ResultUtil.error("图片太大了");

        }
        return ResultUtil.success(url);


    }

    /**
     * 新增帖子
     * @param invitation
     * @return
     */
    @PostMapping("/addInvitaion")
    @ApiOperation(value="新增帖子", notes="新增帖子")
    @ApiImplicitParam(name = "invitation", value = "invitation", required = true, dataType = "Invitation")
    public Result addInvitaion(@RequestBody Invitation invitation){
        //生成帖子id
        String invitationId = sid.nextShort();
        invitation.setInvitationId(invitationId);//插入数据库
        invitation = invitationService.addInvitation(invitation);
        //转换数据给前端，将图片的字符串变成数组传递
        InvitaionDTO invitaionDTO = new InvitaionToInvitaonDTO().invitaionToInvitaonDTO(invitation);
        return ResultUtil.success(invitaionDTO);
    }

    @PostMapping("/getAllInvitation")
    @ApiOperation(value="分页获取帖子数据", notes="分页获取帖子数据")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNumber", value = "pageNumber", required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = true, dataType = "Integer"),
//    })
    @ApiImplicitParam(name = "invitationVO", value = "invitationVO", required = true, dataType = "AllInvitationVO")
   public Result getAllInvitationByPage(@RequestBody AllInvitationVO invitationVO){
        //获取前端参数
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(invitationVO.getPageNum());
        pageRequest.setPageSize(invitationVO.getPageSize());
        //分页查询数据库
        PageResult pageResult = invitationService.findPage(pageRequest);


        //获取在pageInfo中的原始对象
        List<Invitation> invitationList = (List<Invitation>) pageResult.getContent();

        //配置返回信息
        //定义返回给前端的对象,将图片字符串变成数组，并加入到回给前端的对象
        List<InvitaionDTO> invitaionDTOList = invitationListToInvitaionDTOList(invitationList,invitationVO.getCurrentCustomerId());
        //将pageResult中的list替换成返回给前端对象的list
        pageResult.setContent(invitaionDTOList);
        return ResultUtil.success(pageResult);
    }

//  通过帖子id获取帖子的数据
    @ApiOperation(value="通过帖子id获取帖子的数据", notes="通过帖子id获取帖子的数据")
    @GetMapping("getInvitationByInvitationId")
    public Result getInvitationByInvitationId(String currentCustomerId,String invitationId){
        if (StringUtils.isEmpty(currentCustomerId) || StringUtils.isEmpty(invitationId)){
            return ResultUtil.dataNull();
        }

        Invitation invitation = invitationService.getInvitationByInvitationId(invitationId);
//        返回给前端的数据
        InvitaionDTO invitaionDTOResult = new InvitaionToInvitaonDTO().invitaionToInvitaonDTO(invitation);
         //获取发帖人的信息
        Customer customer = new Customer();
        //获取发帖人的信息
        if (!StringUtils.isEmpty(invitation.getInvitationMasterId())){
            customer = customerService.getUserInfoByCusId(invitation.getInvitationMasterId());
        }
//      DTO添加发帖人信息
        invitaionDTOResult.setCustomer(customer);

//      result添加关注标志
//        如果帖子时本人发的，关注状态为null
        if (customer.getCustomerId().equals(currentCustomerId)){
            invitaionDTOResult.setIsFollow(null);
        }else {
            Follow follow = new Follow();
            follow.setFollowedCustomer(customer.getCustomerId());
            follow.setCustomerId(currentCustomerId);
            Boolean isFollow = followService.isFollow(follow);
            invitaionDTOResult.setIsFollow(isFollow);
        }
//      result添加点赞数据，LikeVO
//        判断当前帖子和当前用户是否点赞关系
        LikesVO isLikesVO = likesService.isLike(currentCustomerId,invitation.getInvitationId());
//      设置帖子的点赞数和判断帖子的点赞情况
        invitaionDTOResult.setLikesVO(isLikesVO);

        //通过帖子id获取帖子的评论数量
        int commentCounts = commentService.findCommentCountsByInvitationId(invitation.getInvitationId());
        //DTO添加某个帖子的评论数量
        invitaionDTOResult.setCommentCounts(commentCounts);
        //添加到返回信息中
       return ResultUtil.success(invitaionDTOResult);

    }

    /**
     * 通过 帖子id和发帖人id确认删除帖子
     * @param invitationId
     * @param invitationMasterId
     * @return
     */
    @PostMapping("/delInvitaionByInvitaionIdAndInvitationMasterId")
    @ApiOperation(value="通过帖子id和发帖人id确认删除帖子", notes="通过 帖子id和发帖人id确认删除帖子")
    public Result delInvitaionByInvitaionIdAndInvitationMasterId(String invitationId, String invitationMasterId){

        if (StringUtils.isEmpty(invitationId) || StringUtils.isEmpty(invitationMasterId)){
            return ResultUtil.dataNull();
        }
        boolean ResultFlag =  invitationService.delInvitaionByInvitaionIdAndInvitationMasterId(invitationId, invitationMasterId);

        return ResultFlag ? ResultUtil.success("删除成功"): ResultUtil.error("删除失败");
    }


    /**
     *
     * @param customerId
     * @return
     */
    @PostMapping("getInvitationByCustomerId")
    @ApiOperation(value="查询该用户发布过的全部帖子", notes="查询该用户发布过的全部帖子")
    public Result getInvitationByCustomerId(String customerId, Integer pageNum, Integer pageSize){
        if (StringUtils.isEmpty(customerId)){
            return ResultUtil.dataNull();
        }
        PageRequest pageRequest = new PageRequest(pageNum, pageSize);

        PageResult pageResult =  invitationService.getInvitationByCustomerId(customerId, pageRequest);
        List<Invitation> invitationList = (List<Invitation>) pageResult.getContent();
        List<InvitaionDTO> resultList = invitationListToInvitaionDTOList(invitationList,customerId);
        pageResult.setContent(resultList);
        return ResultUtil.success(pageResult);
    }

    /**
     * 获取某用户的点赞过的帖子
     */
    //  通过用户id查询全部帖子,即全部用户点过赞的帖子
    @ApiOperation(value="全部用户点过赞的帖子", notes="全部用户点过赞的帖子")
    @PostMapping("getAllBeLikedInvitationByCustomerId")
    public Result getAllBeLikedInvitationByCustomerId(String customerId, Integer pageNum, Integer pageSize) {
        if (StringUtils.isEmpty(customerId)){
            return ResultUtil.dataNull();
        }
        PageRequest pageRequest = new PageRequest(pageNum, pageSize);

        PageResult pageResult = new PageResult();
        List<Invitation> invitationList = new ArrayList<>();
//      获取被点过赞的点赞数据
        List<Likes> likesList = likesService.getAllInvitationIdByCustomerId(customerId);
        if (likesList != null){
            //获取这个用户点过赞的帖子id
//            List<String> invitationIdsBeLike = new ArrayList<>();
//            for (Likes likes : likesList){
//                invitationIdsBeLike.add(likes.getInvitationId());
//            }
            pageResult = invitationService.getAllBeLikedInvitationByInvitationList(likesList, pageRequest);
            invitationList = (List<Invitation>) pageResult.getContent();
        }else {
            pageResult = invitationService.getAllBeLikedInvitationByCustomerId(customerId,pageRequest);
            invitationList = (List<Invitation>) pageResult.getContent();
        }

        List<InvitaionDTO> resultList = invitationListToInvitaionDTOList(invitationList,customerId);
        pageResult.setContent(resultList);
        return ResultUtil.success(pageResult);
    }


    /**
     * 将数据库查询返回的信息整理获取返回给前端 invitationList  currentCustomerId,判断当前用户和帖子之间的关系
     * 包括帖子图片、帖子评论数
     * @return
     */
    private List<InvitaionDTO> invitationListToInvitaionDTOList(List<Invitation> invitationList, String currentCustomerId){
        if (invitationList.isEmpty()){
            return null;
        }
        //定义返回给前端的对象
        List<InvitaionDTO> invitaionDTOList = new ArrayList<>();
//       通过个人宠物id获取宠物信息
        PersonPet personPet = null;
        for (Invitation invitation : invitationList){
            Customer customer = new Customer();
            //获取发帖人的信息
            if (!StringUtils.isEmpty(invitation.getInvitationMasterId())){
                customer = customerService.getUserInfoByCusId(invitation.getInvitationMasterId());
            }

            //将invitation中的内容变成DTO内容
            InvitaionDTO invitaionDTO = new InvitaionToInvitaonDTO().invitaionToInvitaonDTO(invitation);

            //用发帖的宠物id变成宠物名称保存返回给前端
            if (!StringUtils.isEmpty(invitaionDTO.getPersonPetsId())){
//                System.out.println("宠物id" + invitaionDTO.getPersonPetsId());
                personPet = personPetService.getPersonPetByPersonPetId(invitaionDTO.getPersonPetsId());
                invitaionDTO.setPersonPetsNickname(personPet.getPetName());
            }

            //发帖人信息存在
            if(customer != null){
                //如果帖子是当前用户自己发的，则返回null,不显示可以关注的按钮
                if (currentCustomerId.equals(customer.getCustomerId())){
                    invitaionDTO.setIsFollow(null);
                }else {
                    //其他的则需要判断当前用户和发帖人的关系
                    Follow follow = new Follow();
                    follow.setCustomerId(currentCustomerId);
                    follow.setFollowedCustomer(customer.getCustomerId());
                    Boolean isFollow = followService.isFollow(follow);
                    invitaionDTO.setIsFollow(isFollow);
                }
            }

//          判断当前帖子和当前用户是否点赞关系
            LikesVO isLikesVO = likesService.isLike(currentCustomerId,invitation.getInvitationId());

//          设置帖子的点赞数和判断帖子的点赞情况
            invitaionDTO.setLikesVO(isLikesVO);

//            DTO添加发帖人信息
            invitaionDTO.setCustomer(customer);
            //通过帖子id获取帖子的评论数量
            int commentCounts = commentService.findCommentCountsByInvitationId(invitation.getInvitationId());
            //DTO添加某个帖子的评论数量
            invitaionDTO.setCommentCounts(commentCounts);
            //添加到返回信息中
            invitaionDTOList.add(invitaionDTO);

        }
        return invitaionDTOList;
    }

    /**
     * 校验输入文字信息,判断输入的文字是否涉嫌违规
     */
    @ApiOperation(value="校验输入文字信息", notes="校验输入文字信息")
    @PostMapping("checkMsg")
    public Result checkMsg(String msg, String accessToken){
//        String url = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token=" + accessToken;
//        JSONObject postData = new JSONObject();
//        postData.put("content", msg);
//        RestTemplate client = new RestTemplate();
//        JSONObject json = client.postForEntity(url, postData, JSONObject.class).getBody();
//        System.out.println(json);
        String url = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token=" + accessToken;
        //创建客户端
        HttpClient httpclient = HttpClients.createDefault();
        //创建一个post请求
        HttpPost request = new HttpPost(url);
        //设置响应头
        request.setHeader("Content-Type", "application/json;charset=UTF-8");
        //通过fastJson设置json数据
        JSONObject postData = new JSONObject();
        postData.put("content", msg);
        String jsonString = postData.toString();
        request.setEntity(new StringEntity(jsonString,"utf-8"));
        //// 由客户端执行(发送)请求
        try {
            HttpResponse response = httpclient.execute(request);
            // 从响应模型中获取响应实体
            HttpEntity entity = response.getEntity();
            //得到响应结果
            String result = EntityUtils.toString(entity,"utf-8");
            //将响应结果变成json
            JSONObject resultJsonObject = JSONObject.parseObject(result, JSONObject.class);
            return ResultUtil.success(resultJsonObject);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultUtil.success("调用出错");
    }

    /**
     * 恶意图片过滤
     * MultipartFile multipartFile, String accessToken
     * @param multipartFile
     * @param accessToken
     * @return
     */
    @ApiOperation(value="校验图片是否含有违法违规内容", notes="校验一张图片是否含有违法违规内容")
    @PostMapping("checkImg")
    public Result<JSONObject> checkImg(MultipartFile multipartFile, String accessToken) throws Exception {

        //压缩图片
        InputStream inputStream = compressImage(multipartFile);

        String url = "https://api.weixin.qq.com/wxa/img_sec_check?access_token=" + accessToken;
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的
        HttpClient httpclient = HttpClients.createDefault();
        //创建一个post请求
        HttpPost request = new HttpPost(url);
        //设置响应头   （ application/octet-stream：二进制流，不知道下载文件类型）
        request.addHeader("Content-Type", "application/octet-stream");
        //输入流
//        InputStream inputStream = multipartFile.getInputStream();
        try {
            //创建一个byte数组，和输入的文件的大小一样
            byte[] byt = new byte[inputStream.available()];
            //从输入流中读取全部，并将其存储在缓冲区数组byt 中。
            inputStream.read(byt);
            //定制提交内容
            request.setEntity(new ByteArrayEntity(byt, ContentType.create("image/jpg")));
            //// 由客户端执行(发送)请求,执行校验
            HttpResponse response = httpclient.execute(request);
            // 从响应模型中获取响应实体
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");// 转成string
//            System.out.println("result：" + result);
            JSONObject postData = new JSONObject();
            postData = JSONObject.parseObject(result, JSONObject.class);
            postData.getString("errcode");
            return ResultUtil.success(postData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 压缩图片
     * @param multipartFile
     */
    @ApiOperation(value="压缩图片", notes="压缩图片")
    @PostMapping("compressImage")
    public InputStream compressImage(MultipartFile multipartFile){
        //获取文件名后缀，判断其格式
        int begin = multipartFile.getOriginalFilename().lastIndexOf(".");
        int last = multipartFile.getOriginalFilename().length();
        //获得文件后缀名
        String houzuiFileName = multipartFile.getOriginalFilename().substring(begin, last);

        //创建临时文件
        File tempFile = new File(multipartFile.getOriginalFilename());
        //写入临时File文件 tempFile，将multipartFile转换成File
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果文件不是jpg格式,转换其格式
        if (!"jpg".equalsIgnoreCase(houzuiFileName)){
            //将png格式转换成jpg，输出到tempFile
            ImageUtils.convert(multipartFile.getOriginalFilename(), "jpg", tempFile.getAbsolutePath());//测试OK

        }
        try {
            //压缩图片
            BufferedImage bufferedImage = Thumbnails.of(tempFile)
                    .size(740, 1330)//图片压缩尺寸
                    .outputQuality(0.8f)//图片压缩质量
                    .asBufferedImage();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", os);
            InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
//            System.out.println(inputStream);
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//             会在本地产生临时文件，用完后需要删除
            if (tempFile.exists()) {
                tempFile.delete();
            }
        }
        return null;
//        OutputStream os = new ByteArrayOutputStream();
//        //先转换成jpg
//        Thumbnails.Builder builder = Thumbnails.of(file.getInputStream()).outputFormat("jpg");
//        //设置大小
//        builder.size(740, 1330);
//        //设置压缩质量
//        builder.outputQuality(0.8f);
//        //输出到输出流中
//        builder.toOutputStream(os);
//        //将输出流变成输入流
//
//        return parse(os);
//        //压缩图片
//        BufferedImage bufferedImage =  Thumbnails.of(file.getInputStream())
//                .size(740, 1330)
//                .outputQuality(0.8f).asBufferedImage();
//        //将压缩之后的图片变成输出流
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpg", os);
//        InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
//        return inputStream;
        //watermark(位置，水印图，透明度).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(newFile("images/watermark.png")),0.5f)
    }

    public File multipartFileToFile(MultipartFile file ) throws Exception {

        File f = new File("D:/740X1330.jpg");
        FileUtils.copyInputStreamToFile(file.getInputStream(), f);
        return f;
    }


    public static void main(String[] args) {
        String str = "2019.05.14.测试.doc";
        System.out.println(str.substring(0,str.lastIndexOf(".")));
    }
}
