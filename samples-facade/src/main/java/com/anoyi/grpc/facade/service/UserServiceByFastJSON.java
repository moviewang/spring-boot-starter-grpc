package com.anoyi.grpc.facade.service;


import com.anoyi.grpc.annotation.GrpcService;
import com.anoyi.grpc.constant.SerializeTypeEnum;
import com.anoyi.grpc.facade.entity.ExpandVo;
import com.anoyi.grpc.facade.entity.UserEntity;

import java.util.List;

@GrpcService(server = "user", serialization = SerializeTypeEnum.FASTJSON)
public interface UserServiceByFastJSON {

    void insert(String userEntityJson);

    void deleteById(String id);

    List<UserEntity> findAll();

    List<ExpandVo> get(int id);

}
