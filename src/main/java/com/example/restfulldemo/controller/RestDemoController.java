package com.example.restfulldemo.controller;

import java.util.Date;

import com.example.restfulldemo.cache.DemoUserLogCache;
import com.example.restfulldemo.Bean.DemoUserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;


@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class RestDemoController {

    @Autowired
    private DemoUserLogCache DemoUserLogCache;

    @RequestMapping(value = "/update")
    public DemoUserLog update(@RequestBody JsonNode jsonNode) {
        System.out.println("jsonNode=" + jsonNode);
        DemoUserLog bean = DemoUserLogCache.selectById(jsonNode.get("id").asInt(1));
        if(bean == null){
            bean = new DemoUserLog();
        }
        bean.setUserName("测试2");
        bean.setCreateTime(new Date());
        bean.setUserIp("192.168.1.1");
        DemoUserLogCache.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public DemoUserLog update2(@PathVariable(value = "id") Integer id) {
        DemoUserLog bean = DemoUserLogCache.selectById(id);
        if(bean == null){
            bean = new DemoUserLog();
        }
        bean.setUserName("测试");
        bean.setCreateTime(new Date());
        bean.setUserIp("192.168.1.1");
        DemoUserLogCache.updateById(bean);
        return bean;
    }

}