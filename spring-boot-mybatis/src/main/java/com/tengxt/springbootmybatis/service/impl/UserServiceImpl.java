package com.tengxt.springbootmybatis.service.impl;

import com.tengxt.springbootmybatis.entity.User;
import com.tengxt.springbootmybatis.mapper.UserMapper;
import com.tengxt.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        int res = 0;
        if(null != user){
            res = userMapper.save(user);
        }
        return res > 0 ? res : 0;
    }

    @Override
    public int update(User user) {
        int res = 0;
        if(null != user){
            res = userMapper.update(user);
        }
        return res > 0 ? res : 0;
    }

    @Override
    public int deleteById(Integer id) {
        int res = 0;
        if(null != id){
            res = userMapper.deleteById(id);
        }
        return res > 0 ? res : 0;
    }

    @Override
    public User queryById(Integer id) {
        User user = null;
        if(null != id){
            user = userMapper.queryById(id);
        }
        return user;
    }
}
