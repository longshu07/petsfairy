package com.longshu.petsfairy.service.Impl;

import com.longshu.petsfairy.dao.GilrMapper;
import com.longshu.petsfairy.entity.Girl;
import com.longshu.petsfairy.service.GilrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :龙叔
 * @description:TODO
 * @date :2019/11/7 10:38
 */
@Service
public class GilrServiceImpl implements GilrService {
    @Resource
    private GilrMapper gilrMapper;

    @Override
    public Girl getUser() {
        return gilrMapper.getUser();
    }
}
