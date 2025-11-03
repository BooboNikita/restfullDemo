package com.example.restfulldemo.util.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfiguration {

    @Bean
    public ActiveMQQueue jmsQueue() {
        return new ActiveMQQueue("demo.queue");
    }
}