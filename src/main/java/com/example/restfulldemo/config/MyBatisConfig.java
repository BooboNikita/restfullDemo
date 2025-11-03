package com.example.restfulldemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.restfulldemo.mapper")
public class MyBatisConfig {
}
