package com.anoyi.grpc.server.dao;

import com.anoyi.grpc.facade.entity.ExpandVo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: movie
 * @Date: 2018/10/28 18:11
 */
public interface UserDao extends MongoRepository<ExpandVo, String> {
}
