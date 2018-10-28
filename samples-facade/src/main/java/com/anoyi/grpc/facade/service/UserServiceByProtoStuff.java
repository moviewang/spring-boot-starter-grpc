package com.anoyi.grpc.facade.service;


import com.anoyi.grpc.annotation.GrpcService;
import com.anoyi.grpc.constant.SerializeTypeEnum;
import com.anoyi.grpc.facade.entity.UserEntity;

import java.util.List;

@GrpcService(server = "user", serialization = SerializeTypeEnum.PROTOSTUFF)
public interface UserServiceByProtoStuff {

    void insert(UserEntity userEntity);

    void deleteById(Long id);

    List<UserEntity> findAll();

}
