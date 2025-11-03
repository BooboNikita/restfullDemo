package com.example.restfulldemo;

import com.example.restfulldemo.Dao.NewsDAO;
import com.example.restfulldemo.Dao.UserDAO;
import com.example.restfulldemo.model.News;
import com.example.restfulldemo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test8ApplicationTests {

    @Autowired
    UserDAO userDAO;

    @Autowired
    NewsDAO newsDAO;

    @Test
    public void contextLoads() {

        Random random = new Random();
        long timestamp = System.currentTimeMillis();

        for (int i = 0; i < 11; ++i) {
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(100)));
            user.setName(String.format("USER%d_%d", i, timestamp));
            user.setPassword("newpassword");
            user.setSalt("");
            userDAO.addUser(user);

            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreatedDate(date);
            news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
            news.setLikeCount(i+1);
            news.setUserId(i+1);
            news.setTitle(String.format("TITLE{%d}", i));
            news.setLink(String.format("http://www.nowcoder.com/%d.html", i));
            newsDAO.addNews(news);

            user.setPassword("newpassword");
            userDAO.updatePassword(user);
        }



        assertEquals("newpassword", userDAO.selectById(1).getPassword());
        userDAO.deleteById(1);
        assertNull(userDAO.selectById(1));
    }
}