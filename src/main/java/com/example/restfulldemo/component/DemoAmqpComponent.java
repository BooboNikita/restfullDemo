package com.example.restfulldemo.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoAmqpComponent {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        this.amqpTemplate.convertAndSend("demodemo.queue", msg);
    }

    @RabbitListener(queues = "demodemo.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

}