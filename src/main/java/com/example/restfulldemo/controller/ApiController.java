package com.example.restfulldemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class ApiController {

    @PostMapping("/get")
    public HashMap<String, Object> postData(@RequestBody Map<String, Object> name) {
        HashMap<String, Object> map = new HashMap<String, Object>(); map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}