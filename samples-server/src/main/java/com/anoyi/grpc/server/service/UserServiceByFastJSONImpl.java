package com.anoyi.grpc.server.service;

import com.alibaba.fastjson.JSONObject;
import com.anoyi.grpc.facade.entity.ExpandVo;
import com.anoyi.grpc.facade.entity.UserEntity;
import com.anoyi.grpc.facade.service.UserServiceByFastJSON;
import com.anoyi.grpc.server.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class UserServiceByFastJSONImpl implements UserServiceByFastJSON {


    /**
     * 模拟数据库存储用户信息
     */
    private Map<Long, UserEntity> userMap = new ConcurrentHashMap<>();
    @Autowired
    private UserDao userDao;

    @Override
    public void insert(String userEntityJson) {
        UserEntity userEntity = JSONObject.parseObject(userEntityJson, UserEntity.class);
        if (userEntity == null){
            log.warn("insert user fail, userEntity is null!");
            return ;
        }
        userMap.putIfAbsent(userEntity.getId(), userEntity);
    }

    @Override
    public void deleteById(String id) {
        if (StringUtils.isEmpty(id)){
            log.warn("delete user fail, id is null!");
        }
        userMap.remove(Long.valueOf(id));
    }

    @Override
    public List<UserEntity> findAll() {
        Collection<UserEntity> values = userMap.values();
        return new ArrayList<>(values);
    }

    @Override
    public List<ExpandVo> get(int id) {
        ArrayList<ExpandVo> list = new ArrayList<>();
        Optional<ExpandVo> ss = userDao.findById(326018 + "");
        if (ss.isPresent()) {
            list.add(ss.get());
        }
        return list;
    }

}
