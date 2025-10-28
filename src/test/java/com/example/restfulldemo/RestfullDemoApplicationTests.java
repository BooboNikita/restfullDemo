package com.example.restfulldemo;

import com.example.restfulldemo.controller.IndexController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RestfullDemoApplicationTests {

    private MockMvc mvc;

    @BeforeEach
    public void before() {
        this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    void contextLoads() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index"))
           .andExpect(status().isOk())
           .andExpect(content().string("hello world!"));
    }

}
