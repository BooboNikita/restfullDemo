package com.example.restfulldemo.cache.impl;

import com.example.restfulldemo.Bean.DemoUserLog;
import com.example.restfulldemo.cache.DemoUserLogCache;
import com.example.restfulldemo.Dao.DemoUserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "demoCache")
@Repository
public class DemoUserLogCacheImpl implements DemoUserLogCache {

    @Autowired
    private DemoUserLogDao demoUserLogDao;

    @Cacheable(key = "'user:' + #id")
    @Override
    public DemoUserLog selectById(Integer id) {
        System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
        return demoUserLogDao.findById(id).orElse(null);
    }

    @CachePut(key = "'user:' + #demoUserLog.id")
    @Override
    public DemoUserLog updateById(DemoUserLog demoUserLog) {
        System.out.println("更新功能，更新缓存，直接写库, id=" + demoUserLog);
        return demoUserLogDao.save(demoUserLog);
    }

    @CacheEvict(key = "'user:' + #id")
    @Override
    public String deleteById(Integer id) {
        System.out.println("删除功能，删除缓存，直接写库, id=" + id);
        return "清空缓存成功";
    }
}