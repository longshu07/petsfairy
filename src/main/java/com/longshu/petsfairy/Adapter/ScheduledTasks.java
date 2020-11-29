package com.longshu.petsfairy.Adapter;

import com.longshu.petsfairy.common.utils.RedisUtils;
import com.longshu.petsfairy.entity.Likes;
import com.longshu.petsfairy.service.LikesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author :龙叔
 * @description: 定时器，将redis的点赞数据同步到数据库中
 * @date :2020/4/17 19:30
 */
@Component
public class ScheduledTasks {
    @Resource
    private RedisUtils redisUtils;

    @Resource
    private LikesService likesService;
    /**
     *
     * 每天十二点执行,将redis数据保存到数据库中
     * @Scheduled(cron = "0 0 0 * * ?")
     * 每两秒执行
        @Scheduled(fixedRate = 2000)
     */
    // 每天十二点执行
    @Scheduled(cron = "0 0 0 * * ?")
//    @Scheduled(fixedRate = 2000)
    public void updateLike() {
        //      获取全部在缓存中的数据
        Map<Object, Object> likesHashMap = redisUtils.hmget("likesHash");

        if (!likesHashMap.isEmpty()) {
//            如果redis有数据，则进行查询
            List<Likes> likesListFromRedis = new ArrayList<>();
            for (Map.Entry<Object, Object> entry : likesHashMap.entrySet()) {
                Likes likes = (Likes) entry.getValue();
//              如果用户id不为null
                if (!StringUtils.isEmpty(likes.getCustomerId()) && !StringUtils.isEmpty(likes.getInvitationId())) {
//                  存入数据库中
                    //如果本身不存在于数据库中，新增，如果存在数据库中，更新
                    likes.setCreatetime(new Date());
                    likesService.updateDatabseInfo(likes);
                }

            }
        }
    }

//    /**
//     * 每隔2小时重新获取AccessToken token
//     */
//    @Scheduled(cron = "0 0 0 * * ?")
////    @Scheduled(fixedRate = 2000)
//    public void getAccessToken() {
//       WechatAdapter wechatAdapter = new WechatAdapter();
//       wechatAdapter.getAccessToken();
//    }

}
