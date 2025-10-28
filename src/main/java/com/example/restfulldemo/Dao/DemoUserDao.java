package com.example.restfulldemo.Dao;


import com.example.restfulldemo.Bean.DemoUser;
import com.example.restfulldemo.Bean.Page;

public interface DemoUserDao {
    int insert(DemoUser demoUser);
    int deleteById(int id);
    int updateById(DemoUser demoUser);
    DemoUser selectById(int id);
    Page<DemoUser> queryForPage(int pageCurrent, int pageSize, String name);
}