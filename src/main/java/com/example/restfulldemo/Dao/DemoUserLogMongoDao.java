package com.example.restfulldemo.Dao;

import com.example.restfulldemo.Bean.DemoUserMongoLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemoUserLogMongoDao  extends MongoRepository<DemoUserMongoLog, Integer> {

    DemoUserMongoLog findByUserName(String username);

    DemoUserMongoLog findByUserNameAndUserIp(String string, String ip);

    Page<DemoUserMongoLog> findByUserName(String string, Pageable pageable);
}