package com.example.restfulldemo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.restfulldemo.Bean.DemoUserLog;
import com.example.restfulldemo.cache.DemoUserLogCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private DemoUserLogCache demoUserLogCache;

    @PostMapping("/get")
    public HashMap<String, Object> postData(@RequestBody Map<String, Object> name) {
        HashMap<String, Object> map = new HashMap<String, Object>(); map.put("title", "hello world");
        map.put("name", name);
        return map;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public DemoUserLog get(@RequestParam(defaultValue = "1") Integer id) {
        return demoUserLogCache.selectById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public DemoUserLog update(@RequestParam(defaultValue = "1") Integer id) {
        DemoUserLog bean = demoUserLogCache.selectById(id);
        bean.setUserName("测试");
        bean.setCreateTime(new Date());
        demoUserLogCache.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(@RequestParam(defaultValue = "1") Integer id) {
        return demoUserLogCache.deleteById(id);
    }
}