package com.example.restfulldemo;

import com.example.restfulldemo.component.DemoAmqpComponent;
import com.example.restfulldemo.component.DemoJmsComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test7ApplicationTests {

    @Autowired
    private DemoJmsComponent demoJmsComponent;

    @Autowired
    private DemoAmqpComponent demoAmqpComponent;

    @Test
    public void send() {
        demoJmsComponent.send("hello world");
    }

    @Test
    public void sendMultipleMessages() {
        System.out.println("开始发送消息...");
        
        // 发送5条消息
        for (int i = 1; i <= 5; i++) {
            String message = "消息 " + i + " - " + System.currentTimeMillis();
            System.out.println("发送: " + message);
            demoAmqpComponent.send(message);
            
            // 添加短暂延迟，使消息发送有时间间隔
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // 等待所有消息处理完成
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    @Test
    public void testParallelProcessing() {
        System.out.println("开始并发发送消息...");
        
        // 创建多个线程并发发送消息
        for (int i = 1; i <= 5; i++) {
            final int messageNum = i;
            new Thread(() -> {
                String message = "并发消息 " + messageNum + " - " + Thread.currentThread().getName();
                System.out.println("发送: " + message);
                demoAmqpComponent.send(message);
            }).start();
        }
        
        // 等待所有消息处理完成
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}