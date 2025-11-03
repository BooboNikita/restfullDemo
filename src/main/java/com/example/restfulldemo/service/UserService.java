package com.example.restfulldemo.service;

import com.example.restfulldemo.Dao.DemoUserDao;
import com.example.restfulldemo.Dao.DemoUserLogDao;
import com.example.restfulldemo.Bean.DemoUser;
import com.example.restfulldemo.Bean.DemoUserLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private DemoUserDao demoUserDao;

    @Autowired
    private DemoUserLogDao demoUserLogDao;

    /**
     * 用户注册
     *
     * @return
     */
//    @Transactional
    public String register(String name, String ip) {
        // 1.添加用户
        DemoUser demoUser = new DemoUser();
        demoUser.setName(name);
        demoUser.setCreateTime(new Date());
        demoUserDao.insert(demoUser);

        // 测试使用
        boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }

        // 2.添加注册日志
        DemoUserLog demoUserLog = new DemoUserLog();
        demoUserLog.setUserName(name);
        demoUserLog.setUserIp(ip);
        demoUserLog.setCreateTime(new Date());
        demoUserLogDao.save(demoUserLog);

        return "success";
    }

}