package com.example.restfulldemo;

import com.example.restfulldemo.Bean.DemoUserLog;
import com.example.restfulldemo.Dao.DemoUserLogDao;
import com.example.restfulldemo.service.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test2ApplicationTests {

    @Autowired
    private DemoUserLogDao demoUserLogDao;

    @Autowired
    private  UserService userService;

    @Test
    @Order(1)
    public void insert() {
        DemoUserLog entity = new DemoUserLog();
        entity.setUserName("无境");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        demoUserLogDao.save(entity);
    }



    @Test
    @Order(3)
    public void delete() {
        demoUserLogDao.deleteById(2);
    }


    @Test
    @Order(2)
    public void update() {
        DemoUserLog entity = new DemoUserLog();
        entity.setId(2);
        entity.setUserName("无境 2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        demoUserLogDao.save(entity);
    }


    @Test
    @Order(4)
    public void select() {
        DemoUserLog result = demoUserLogDao.findById(1).get();
        System.out.println(result);
    }

    @Test
    public void select2() {
        List<DemoUserLog> result = demoUserLogDao.findByUserName("无境");
        System.out.println(result);
    }

    @Test
    public void select3() {
        List<DemoUserLog> result = demoUserLogDao.findByUserNameAndUserIp("无境", "192.168.0.1");
        System.out.println(result);
    }

    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable =  PageRequest.of(0, 20,  Sort.by(new Sort.Order(Direction.ASC, "id")));
        Page<DemoUserLog> result = demoUserLogDao.findByUserName("无境", pageable);
        System.out.println(result.getContent());
    }

    @Test
    public void register() {
        String result = userService.register("无境ff", "192.168.1.1");
        System.out.println(result);
    }
}