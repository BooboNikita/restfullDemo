package com.example.restfulldemo.component;

import com.example.restfulldemo.Bean.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class DemoMongodbComponent {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(DemoUser demoUser) {
        mongoTemplate.insert(demoUser);
    }

    public void deleteById(int id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, DemoUser.class);
    }

    public void updateById(DemoUser demoUser) {

        Criteria criteria = Criteria.where("_id").in(demoUser.getId());
        Query query = new Query(criteria);
        Update update = new Update();

        update.set("name", demoUser.getName());
        update.set("createTime", demoUser.getCreateTime());
        mongoTemplate.updateMulti(query, update, DemoUser.class);

    }

    public DemoUser selectById(int id) {
        return mongoTemplate.findById(id, DemoUser.class);
    }
}