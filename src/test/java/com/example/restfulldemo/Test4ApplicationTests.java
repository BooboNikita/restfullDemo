package com.example.restfulldemo;

import com.example.restfulldemo.Bean.DemoUser;
import com.example.restfulldemo.component.DemoMongodbComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test4ApplicationTests {

    @Autowired
    private DemoMongodbComponent demoMongodbComponent;

//    @Test
//    public void set() {
//        DemoUser demoUser = new DemoUser();
//        demoUser.setId(1);
//        demoUser.setName("虾米1");
//        demoUser.setCreateTime(new Date());
//        demoMongodbComponent.insert(demoUser);
//    }

    @Test
    public void select() {
        System.out.println(demoMongodbComponent.selectById(1));
    }

    @Test
    public void update() {
        DemoUser demoUser = new DemoUser();
        demoUser.setId(1);
        demoUser.setName("测试修改");
        demoUser.setCreateTime(new Date());
        demoMongodbComponent.updateById(demoUser);
        System.out.println(demoMongodbComponent.selectById(1));
    }

    @Test
    public void delete() {
        demoMongodbComponent.deleteById(1);
    }
}