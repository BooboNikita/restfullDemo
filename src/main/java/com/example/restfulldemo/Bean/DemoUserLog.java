package com.example.restfulldemo.Bean;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DemoUserLog extends BaseUserLog implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }

    // 可以添加JPA特有的注解
    @Column(name = "create_time")
    @Override
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Column(name = "user_name", length = 100)
    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Column(name = "user_name", length = 100)
    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Column(name = "user_ip", length = 50)
    @Override
    public String getUserIp() {
        return super.getUserIp();
    }
}
