package com.tengxt.springbootmybatismultidatasource.service;

import com.tengxt.springbootmybatismultidatasource.entity.User;

import java.util.List;

public interface UserService {
    //  查询 test01数据库的数据
    List<User> queryUserOneAll();
    //  查询 test02数据库的数据
    List<User> queryUserTwoAll();
}
