package com.example.restfulldemo;

import com.example.restfulldemo.Bean.DemoUserLog;
import com.example.restfulldemo.Dao.DemoUserLogDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2ApplicationTests {

    @Autowired
    private DemoUserLogDao demoUserLogDao;

    @Test
    public void insert() {
        DemoUserLog entity = new DemoUserLog();
        entity.setUserName("无境");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        demoUserLogDao.save(entity);
    }


    @Test
    public void delete() {
        demoUserLogDao.deleteById(2);
    }


    @Test
    public void update() {

        DemoUserLog entity = new DemoUserLog();
        entity.setId(2);
        entity.setUserName("无境 2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        demoUserLogDao.save(entity);
    }


    @Test
    public void select() {
        DemoUserLog result = demoUserLogDao.findById(1).get();
        System.out.println(result);
    }
}