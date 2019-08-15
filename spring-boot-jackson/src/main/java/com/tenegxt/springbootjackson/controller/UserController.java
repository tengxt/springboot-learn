package com.tenegxt.springbootjackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenegxt.springbootjackson.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/getUser")
    //@JsonView(User.UserNameView.class)
    @JsonView(User.AllUserFieldView.class)
    public User getUser(){
        User user = new User();
        user.setUserName("tengxt");
        user.setAge(20);
        user.setBirthday(new Date());
        return user;
    }

    /**
     * 将Java对象序列化为JSON格式字符串
     * @return
     */
    @GetMapping("/getSerUser")
    public String getSerializationUser(){
        try {
            User user = new User();
            user.setUserName("tengxt");
            user.setAge(20);
            user.setBirthday(new Date());
            return  mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 树遍历,
     * @return
     */
    @GetMapping("/readJsonString")
    public String readJsonString(){
        try {
            String json ="{\"userName\":\"tengxt\",\"age\":20}";
            JsonNode node = this.mapper.readTree(json);
            String userName = node.get("userName").asText();
            int age = node.get("age").asInt();
            return userName + " " + age;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解析多级Json
     * @return
     */
    @GetMapping("/readMenuJsonString")
    public String readMenuJsonString(){
        try {
            String json="{\"userName\":\"tengxt\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";
            JsonNode jsonNode = this.mapper.readTree(json);
            JsonNode hobby = jsonNode.get("hobby");
            String firstStr = hobby.get("first").asText();
            String secondStr = hobby.get("second").asText();
            return firstStr + " " + secondStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JSON对象转Java对象
     * @return
     */
    @GetMapping("/readJsonAsObject")
    public String readJsonAsObject(){
        try {
            String json ="{\"userName\":\"tengxt\",\"age\":20}";
            User user = mapper.readValue(json, User.class);
            String userName = user.getUserName();
            Integer age = user.getAge();
            return userName + " " + age;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/updateUser")
    public int updateUser(@RequestBody List<User> users){
        System.out.println(users);
        return users.size();
    }


    @GetMapping("customize")
    public String customize() throws JsonParseException, JsonMappingException, IOException {
        String jsonStr = "[{\"userName\":\"tengxt1\",\"age\":21},{\"userName\":\"tengxt2\",\"age\":22}]";
        //List<User> list = mapper.readValue(jsonStr, List.class);
        // 抛出异常： java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to com.tenegxt.springbootjackson.entity.User
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (User user : list) {
            msg += user.getUserName();
        }
        return msg;
    }


}
