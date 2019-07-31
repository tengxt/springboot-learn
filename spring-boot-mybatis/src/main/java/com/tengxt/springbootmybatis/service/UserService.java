package com.tengxt.springbootmybatis.service;

import com.tengxt.springbootmybatis.entity.User;

public interface UserService {
    int save(User user);
    int update(User user);
    int deleteById(Integer id);
    User queryById(Integer id);
}
