package com.example.restfulldemo;

import com.example.restfulldemo.Dao.DemoUserDao;
import com.example.restfulldemo.Bean.DemoUser;
import com.example.restfulldemo.Bean.Page;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test1ApplicationTests {

    @Autowired
    private DemoUserDao demoUserDao;

    @Test
    public void insert() {

        DemoUser demoUser = new DemoUser();
        demoUser.setName("测试");
        demoUser.setCreateTime(new Date());
        int result = demoUserDao.insert(demoUser);
        System.out.println(result);

    }

    @Test
    public void delete() {
        int result = demoUserDao.deleteById(1);
        System.out.println(result);

    }

    @Test
    public void update() {

        DemoUser demoUser = new DemoUser();
        demoUser.setId(2);
        demoUser.setName("测试 2");
        demoUser.setCreateTime(new Date());
        int result = demoUserDao.updateById(demoUser);
        System.out.println(result);
    }

    @Test
    public void select() {
        DemoUser result = demoUserDao.selectById(2);
        System.out.println(result);
    }

    //    分页测试
    @Test
    public void queryForPage(){
        Page<DemoUser> result = demoUserDao.queryForPage(1, 20, "测试");

        System.out.println(result.getList());
    }
}