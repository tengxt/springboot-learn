package com.tengxt.springboottesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tengxt.springboottesting.entity.SysLog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void findByName() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/log/{userName}", "tengxt")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tengxt"))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    @Transactional
    public void save() throws Exception {
        SysLog sysLog = new SysLog();
        sysLog.setUsername("tengxt111");
        sysLog.setOperation("测试");
        sysLog.setTime("111");
        sysLog.setMethod("com.tengxt.springboottesting.service.SysLogServiceTest.save");
        sysLog.setIp("127.0.0.1");
        sysLog.setCreateTime(new Date());
        sysLog.setParams("");

        String userJson = mapper.writeValueAsString(sysLog);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/log/save")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(userJson.getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
