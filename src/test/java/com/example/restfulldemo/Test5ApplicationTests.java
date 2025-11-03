package com.example.restfulldemo;

import com.example.restfulldemo.Bean.DemoUserMongoLog;
import com.example.restfulldemo.Dao.DemoUserLogMongoDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test5ApplicationTests {

    @Autowired
    private DemoUserLogMongoDao demoUserLogMongoDao;

    @Test
    public void insert() {
        DemoUserMongoLog entity = new DemoUserMongoLog();
        entity.setId(1);
        entity.setUserName("无境");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        demoUserLogMongoDao.save(entity);
    }

    @Test
    public void delete() {
        demoUserLogMongoDao.deleteById(1);
    }

    @Test
    public void update() {

        DemoUserMongoLog entity = new DemoUserMongoLog();
        entity.setId(1);
        entity.setUserName("无境2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        demoUserLogMongoDao.save(entity);
    }

    @Test
    public void select() {
        DemoUserMongoLog result = demoUserLogMongoDao.findById(1).get();
        System.out.println(result);
    }

    @Test
    public void select2() {
        DemoUserMongoLog result = demoUserLogMongoDao.findByUserName("无境2");
        System.out.println(result);
    }

    //    分页
    @Test
    public void queryForPage() {
        Pageable pageable = PageRequest.of(0, 20,  Sort.by(new Sort.Order(Direction.DESC, "id")));
        //  Page<DemoUserLog> result = demoUserLogDao.findByUserName("无境2", pageable);
        Page<DemoUserMongoLog> result = demoUserLogMongoDao.findAll(pageable);
        System.out.println(result.getContent());
    }
}