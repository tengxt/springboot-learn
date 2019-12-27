package com.tengxt.community.service;

import com.tengxt.community.bean.User;
import com.tengxt.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean createOrUpdate(User user) {
        boolean flag = false;
        List<User> userList = userMapper.findByAccId(user.getAccountId());
        if(0 == userList.size()){
            // 插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            int res = userMapper.insert(user);
            flag =  res > 0 ? true : false;
        }else{
            //更新
            User dbUser = userList.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            updateUser.setId(dbUser.getId());
            int res = userMapper.update(updateUser);
            flag =  res > 0 ? true : false;
        }
        return flag;
    }
}
