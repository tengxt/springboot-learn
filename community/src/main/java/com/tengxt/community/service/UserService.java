package com.tengxt.community.service;

import com.tengxt.community.bean.User;
import com.tengxt.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user){
        // 补全pojo
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        return userMapper.insert(user);
    }

    public User fingByToken(String token){
        return userMapper.findByToken(token);
    }
}
