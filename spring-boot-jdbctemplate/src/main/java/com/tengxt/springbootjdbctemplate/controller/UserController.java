package com.tengxt.springbootjdbctemplate.controller;

import com.tengxt.springbootjdbctemplate.entity.User;
import com.tengxt.springbootjdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/queryAll")
    public List<Map<String, Object>> queryUserAll(){
        return userService.queryUsersListMap();
    }

    @GetMapping("/queryById/{id}")
    public User queryUserById(@PathVariable Integer id){
        return userService.queryUsersById(id);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable Integer id){
        int res = userService.deleteById(id);
        return res > 0 ? "删除成功" : "删除失败";
    }

    @PostMapping("/save")
    public String saveUser(User user){
        int res = userService.save(user);
        return res > 0 ? "添加成功" : "添加失败";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        int res = userService.update(user);
        return res > 0 ? "修改成功" : "修改失败";
    }
}
