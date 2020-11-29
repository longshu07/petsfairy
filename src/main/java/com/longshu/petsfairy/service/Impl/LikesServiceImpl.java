package com.longshu.petsfairy.service.Impl;

import com.longshu.petsfairy.VO.LikesVO;
import com.longshu.petsfairy.common.utils.RedisUtils;
import com.longshu.petsfairy.dao.InvitationMapper;
import com.longshu.petsfairy.dao.LikesMapper;
import com.longshu.petsfairy.entity.Likes;
import com.longshu.petsfairy.entity.LikesExample;
import com.longshu.petsfairy.service.LikesService;
import net.bytebuddy.asm.Advice;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Likes)表服务实现类
 *
 * @author makejava
 * @since 2020-04-16 16:36:40
 */
@Service("likesService")
public class LikesServiceImpl implements LikesService {
    @Resource
    private LikesMapper likesDao;
    @Resource
    private RedisUtils redisUtils;

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private InvitationMapper invitationMapper;


    //redis中存储的key名称规则
    private static String isLikesKey(String id){
        return "isLikes:" + id;
    }

    /**
     * 新增赞
     * @param likes
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean insertLike(Likes likes) {
        int flag = likesDao.insertSelective(likes);
//        新增成功，点赞数加+1，应该将当前的数据（存一个likes对象）也存入缓存中，hash,在customerId前面加一个字符串"likesId:"，让其唯一
        if (flag > 0){
//      将缓存信息存入redis中
            redisUtils.hset("likesHash", likes.getCustomerId()+likes.getInvitationId(),likes);
            redisUtils.incr(likes.getInvitationId(),1);
            return true;
        }
        return false;
    }

//  修改点赞表内容
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean updateLikes(Likes likes) {
//      判断是否存在于redis中，存在，则修改在redis的数据
        Likes likesFromRedis = (Likes) redisUtils.hget("likesHash",likes.getCustomerId()+likes.getInvitationId());

        if (likesFromRedis != null){
//          更新数据
            redisUtils.hset("likesHash", likes.getCustomerId()+likes.getInvitationId(),likes);
//          更新点赞的数量
            if ( 1 == likes.getIsDelete()){
                redisUtils.incr(likes.getInvitationId(),1);
            }else {
                redisUtils.decr(likes.getInvitationId(),1);

            }
             return true;
        }
//      不存在redis中，新增redis数据
        int flag = likesDao.updateByPrimaryKeySelective(likes);
        if (flag > 0){
            if (likes.getIsDelete() == 1){
//                如果修改为1，则说明点赞,存入缓存
                redisUtils.incr(likes.getInvitationId(),1);

            }else {
//                如果修改为0，则说明取消点赞,存入缓存
                redisUtils.decr(likes.getInvitationId(),1);
            }
            redisUtils.hset("likesHash", likes.getCustomerId()+likes.getInvitationId(),likes);
            return true;
        }
        return false;
    }
//  查询当前用户和帖子是否在数据库中为点赞关系
    @Override
    public Likes isExitDatabase(String customerId, String invitationId) {
//       判断是否存在于数据库中，从redis缓存中获取
        Likes likesFromRedis = (Likes) redisUtils.hget("likesHash",customerId+invitationId);
        if (likesFromRedis != null){
            System.out.println("isExitDatabase:"+likesFromRedis.toString());
            return likesFromRedis;
        }

        LikesExample likesExample = new LikesExample();
        LikesExample.Criteria criteria = likesExample.createCriteria();
        criteria.andInvitationIdEqualTo(invitationId);
        criteria.andCustomerIdEqualTo(customerId);
        List<Likes> likesList = likesDao.selectByExample(likesExample);
//        如果为空，则返回空，说明灭有关系
        if (likesList.isEmpty()){
            return null;
        }
//      不为空，返回查询出来的这个对象
        return likesList.get(0);
    }


//  通过用户id查询全部帖子,即全部用户点过赞的帖子
    @Override
    public List<Likes> getAllInvitationIdByCustomerId(String customerId) {

//      从缓存中获取这个用户和帖子的关系

//      获取全部在缓存中的数据
        Map<Object, Object> likesHashMap = redisUtils.hmget("likesHash");

        if (!likesHashMap.isEmpty()){
//            如果redis有数据，则进行查询
            List<Likes> likesListFromRedis = new ArrayList<>();
            for (Map.Entry<Object, Object> entry : likesHashMap.entrySet()){
                Likes likes  = (Likes) entry.getValue();
//                如果这个帖子是这个用户关注的了
                if (customerId.equals(likes.getCustomerId()) && 1 == likes.getIsDelete()){
                    likesListFromRedis.add(likes);
                }

            }
            return likesListFromRedis;
        }
        return null;
    }

//  判断帖子和当前用户的点赞关系,likeVO对象，包括是否为为点赞关系，以及这个帖子的点赞数量

    /**
     * 判断帖子和当前用户的点赞关系,likeVO对象，包括是否为为点赞关系，以及这个帖子的点赞数量
     * @param customerId
     * @param invitationId
     * @return
     */
    @Override
    public LikesVO isLike(String customerId, String invitationId) {
//      判断是否存在于缓存中，从redis缓存中获取，
        Likes likesFromRedis = (Likes) redisUtils.hget("likesHash",customerId+invitationId);
        Integer likesBetweenUserAndInvitationCountsFromRedis = (Integer) redisUtils.get(invitationId);
        if (likesFromRedis != null){
            LikesVO likesVO = new LikesVO();
            if (likesFromRedis.getIsDelete() == 0){
                likesVO.setIsLikes(false);
            }else {
                likesVO.setIsLikes(true);
            }
            if (likesBetweenUserAndInvitationCountsFromRedis != null){
                likesVO.setInvitationLikesCounts(likesBetweenUserAndInvitationCountsFromRedis);
            }
            return likesVO;

        }
//        从数据库中获取信息
        LikesExample likesExample = new LikesExample();
        LikesExample.Criteria criteria = likesExample.createCriteria();
        criteria.andInvitationIdEqualTo(invitationId);
        criteria.andCustomerIdEqualTo(customerId);
//        查询是否为点赞关系
        criteria.andIsDeleteEqualTo(1);
//        如果能查询出来，即list不为空，则是点赞关系，false则不是点赞关系
        List<Likes> likesList = likesDao.selectByExample(likesExample);
//        调用查询
        Integer counts = getAllLikesCountsByInvitationId(invitationId);
//        设置返回数据
        LikesVO likesVO = new LikesVO(!likesList.isEmpty(),counts);
        Likes likes = new Likes();
        likes.setCustomerId(customerId);
        likes.setInvitationId(invitationId);
        //只吧已经存储在数据库中的关系

//      为null，设置为0，即没有关系
        if (likesList.isEmpty()){
            //数据库中没有和这个数据，date是null，所以
            //设置判断的时间，加入数据库时不报错
            likes.setCreatetime(new Date());
            likes.setIsDelete(0);
        }else {
//          不为null,即在数据库中有这个数据了，是点赞关系
            likes.setIsDelete(1);
        }

        redisUtils.hset("likesHash", customerId+invitationId, likes);

//        Map<String,Object> likesVOMap = new HashMap();
//        likesVOMap.put(invitationId,likesVO);
////      将缓存信息存入redis中
//        redisUtils.hashSetValue(isLikesKey(customerId),likesVOMap);
//        System.out.println(redisUtils.hget(isLikesKey(customerId),invitationId));
        return new LikesVO(!likesList.isEmpty(),counts);
    }

    //根据帖子id获取这个帖子的点赞数
    @Override
    public Integer getAllLikesCountsByInvitationId(String invitationId) {
        //从redis中获取这个帖子的点赞数,如果不为null，说明有数据 ，直接返回
        Integer likesBetweenUserAndInvitationCountsFromRedis = (Integer) redisUtils.get(invitationId);
        if (likesBetweenUserAndInvitationCountsFromRedis != null){
            return likesBetweenUserAndInvitationCountsFromRedis;
        }

        //redis中没存点赞数的情况
        //先从mysql里把点赞数取出来
        LikesExample likesExample = new LikesExample();
        LikesExample.Criteria criteria =  likesExample.createCriteria();
        criteria.andInvitationIdEqualTo(invitationId);
        criteria.andIsDeleteEqualTo(1);
        Integer likesBetweenUserAndInvitationCountsFromDataBase =  likesDao.countByExample(likesExample);
//        存入redis缓存中
        redisUtils.set(invitationId,likesBetweenUserAndInvitationCountsFromDataBase);
        return likesBetweenUserAndInvitationCountsFromDataBase;
    }

    //  删除数据
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean delLike(Likes likes) {
        int flag = likesDao.deleteByPrimaryKey(likes);
        return flag>0 ? true : false;
    }

    @Override
    public List<Likes> getAllLikes() {
        return likesDao.selectByExample(null);
    }

    /**
     * 通过帖子idlist，获取这些帖子的点赞数
     * 通过用户id获取查询帖子数据，找寻在likes表中帖子id相同的数目
     * @param invitationIdList
     * @return
     */
    @Override
    public int getLikesCountsByInvitationIdList(List<String> invitationIdList) {
//      从缓存中获取数据,如何判断缓存中的数据是完整亦或不完整
        Integer likesCountsFromRedis = 0;
        for (String invitationId : invitationIdList){
            likesCountsFromRedis = likesCountsFromRedis + (Integer) redisUtils.get(invitationId);
        }

        return likesCountsFromRedis;

//        LikesExample likesExample = new LikesExample();
//        LikesExample.Criteria criteria = likesExample.createCriteria();
//        criteria.andIsDeleteEqualTo(1);
//        criteria.andInvitationIdIn(invitationIdList);
//        likesDao.countByExample(likesExample);
//        return likesDao.countByExample(likesExample);
    }





    /**
     * 定时器使用，向数据库中新增数据
     * @param likes
     */
    @Override
    public void updateDatabseInfo(Likes likes){
        LikesExample likesExample = new LikesExample();
        LikesExample.Criteria criteria = likesExample.createCriteria();
        criteria.andInvitationIdEqualTo(likes.getInvitationId());
        criteria.andCustomerIdEqualTo(likes.getCustomerId());
        List<Likes> likesList = likesDao.selectByExample(likesExample);
//       如果为null,新增
        if (likesList.isEmpty()){
            likesDao.insertSelective(likes);
        }
//      不为空，更新
        likesDao.updateByPrimaryKey(likes);
    }


}