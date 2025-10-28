package com.example.restfulldemo.controller;

import com.example.restfulldemo.Bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping(value = "index")
    public String index()
    {
        return "hello world!";
    }

    @Value(value = "${demo.secret}")
    private String secret;

    @Value(value = "${demo.number}")
    private String number;

    @Value(value = "${demo.name}")
    private String name;

    @Value(value = "${demo.desc}")
    private String desc;

    @RequestMapping(value = "get")
    public Map<String, String> get(@RequestParam  String name) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("value", "hello world！");
        return map;
    }

    @RequestMapping(value =  "find/{id}/{name}")
    public User get(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping(value = "getRandom")
    public Map<String, Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("secret", secret);
        map.put("number", number);
        return map;
    }

    @RequestMapping(value = "info")
    public Map<String, Object> info() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("desc", desc);
        return map;
    }

}