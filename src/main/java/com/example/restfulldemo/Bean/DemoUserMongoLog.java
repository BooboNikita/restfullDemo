package com.example.restfulldemo.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class DemoUserMongoLog extends BaseUserLog {

    @Id
    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    // 可以添加MongoDB特有的注解
    @Field("create_time")
    @Override
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Field("user_name")
    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Field("user_ip")
    @Override
    public String getUserIp() {
        return super.getUserIp();
    }
}
