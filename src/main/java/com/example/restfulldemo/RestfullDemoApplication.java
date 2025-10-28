package com.example.restfulldemo;

import com.example.restfulldemo.util.filter.CustomFilter;
import com.example.restfulldemo.util.servlet.CustomServlet;
import com.example.restfulldemo.util.listener.CustomListener;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;


import java.util.EnumSet;

@SpringBootApplication
@ServletComponentScan
public class RestfullDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfullDemoApplication.class, args);
    }
}
