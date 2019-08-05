package com.tengxt.springbootmybatismultidatasource.service.impl;

import com.tengxt.springbootmybatismultidatasource.entity.User;
import com.tengxt.springbootmybatismultidatasource.mapper.UserOneMapper;
import com.tengxt.springbootmybatismultidatasource.mapper.UserTwoMapper;
import com.tengxt.springbootmybatismultidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserOneMapper userOneMapper;

    @Autowired
    private UserTwoMapper userTwoMapper;

    @Override
    public List<User> queryUserOneAll() {
        return userOneMapper.queryUserOneAll();
    }

    @Override
    public List<User> queryUserTwoAll() {
        return userTwoMapper.queryUserTwoAll();
    }
}
