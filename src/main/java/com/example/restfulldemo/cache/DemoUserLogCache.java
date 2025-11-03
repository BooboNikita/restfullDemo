package com.example.restfulldemo.cache;


import com.example.restfulldemo.Bean.DemoUserLog;

public interface DemoUserLogCache {

    /**
     * 查询
     *
     * @param id
     * @return
     */
    DemoUserLog selectById(Integer id);

    /**
     * 更新
     *
     * @param roncooUserLog
     * @return
     */
    DemoUserLog updateById(DemoUserLog roncooUserLog);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    String deleteById(Integer id);
}