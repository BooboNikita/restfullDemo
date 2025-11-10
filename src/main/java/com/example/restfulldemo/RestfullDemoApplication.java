package com.example.restfulldemo;

import com.example.restfulldemo.util.filter.CustomFilter;
import com.example.restfulldemo.util.servlet.CustomServlet;
import com.example.restfulldemo.util.listener.CustomListener;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;


import java.util.EnumSet;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
@EnableJms
@EnableRabbit
@ImportResource(locations = { "classpath:druid-bean.xml" })
@MapperScan(basePackages = "com.example.restfulldemo.Dao", 
            annotationClass = org.apache.ibatis.annotations.Mapper.class)
@EnableJpaRepositories(basePackages = "com.example.restfulldemo.Dao")
public class RestfullDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfullDemoApplication.class, args);
    }
}
