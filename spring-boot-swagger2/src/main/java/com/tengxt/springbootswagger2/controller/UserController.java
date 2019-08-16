package com.tengxt.springbootswagger2.controller;

import com.tengxt.springbootswagger2.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户管理Controller")
@Controller
@RequestMapping("/user")
public class UserController {

    @ApiIgnore
    @GetMapping("/hello")
    public @ResponseBody String hello(){
        return "hello";
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户编号获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable(value = "id") Long id){
        User user = new User();
        user.setId(id);
        user.setName("tengxt");
        user.setAge(20);
        return user;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public @ResponseBody List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L,"tengxt11",21);
        userList.add(user1);
        User user2 = new User(2L,"tengxt22",22);
        userList.add(user2);
        return userList;
    }

    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/add")
    public @ResponseBody Map<String, Object> addUser(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        map.put("code","1");
        map.put("msg","添加成功");
        return map;
    }

    @ApiOperation(value = "更新用户", notes = "根据用户编号更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public @ResponseBody Map<String, Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        map.put("code","1");
        map.put("msg","修改成功");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户编号删除用户")
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public @ResponseBody Map<String, Object> deleteUser(@PathVariable(value = "id") Long id){
        Map<String, Object> map = new HashMap<>();
        map.put("code","1");
        map.put("msg","删除成功");
        return map;
    }
}
