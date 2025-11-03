package com.example.restfulldemo;

import com.example.restfulldemo.component.DemoRedisComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test3ApplicationTests {

    @Autowired
    private DemoRedisComponent demoRedisComponent;

    @Test
    public void set() {
        demoRedisComponent.set("demo", "hello world");
    }

    @Test
    public void get() {
        System.out.println(demoRedisComponent.get("demo"));
    }

    @Test
    public void del() {
        System.out.println(demoRedisComponent.del("demo"));
    }

}