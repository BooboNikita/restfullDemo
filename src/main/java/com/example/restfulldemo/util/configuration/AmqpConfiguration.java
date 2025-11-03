package com.example.restfulldemo.util.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * amqp 队列配置
 */
@Configuration
public class AmqpConfiguration {

    @Bean
    public Queue amqpQueue() {
        return new Queue("demodemo.queue"); //创业队列
    }
}