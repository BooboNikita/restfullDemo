package com.example.restfulldemo;

import com.example.restfulldemo.Bean.DemoUserLog;
import com.example.restfulldemo.cache.DemoUserLogCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test6ApplicationTests {

    @Autowired
    private DemoUserLogCache demoUserLogCache;

    @Test
    public void testCache() {
        Integer testId = 1; // 使用一个存在的ID

        System.out.println("第一次查询（应该从数据库获取）:");
        DemoUserLog user1 = demoUserLogCache.selectById(testId);
        System.out.println("查询结果: " + user1);

        System.out.println("\n第二次查询（应该从缓存获取）:");
        DemoUserLog user2 = demoUserLogCache.selectById(testId);
        System.out.println("查询结果: " + user2);

        // 验证两个对象是否相同
        System.out.println("\n两次查询结果是否相同: " + (user1 == user2));

        // 更新数据
        System.out.println("\n更新数据...");
        user1.setUserName("new_username");
        demoUserLogCache.updateById(user1);

        // 再次查询，应该获取到更新后的数据
        System.out.println("\n更新后查询（应该从数据库获取新数据）:");
        DemoUserLog user3 = demoUserLogCache.selectById(testId);
        System.out.println("查询结果: " + user3);

        // 删除缓存
        System.out.println("\n删除缓存...");
        demoUserLogCache.deleteById(testId);

        // 再次查询，应该从数据库获取
        System.out.println("\n删除后查询（应该从数据库获取）:");
        DemoUserLog user4 = demoUserLogCache.selectById(testId);
        System.out.println("查询结果: " + user4);
    }
}