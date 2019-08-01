package com.tengxt.springbootjdbctemplate.service;

import com.tengxt.springbootjdbctemplate.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int save(User user);

    int update(User user);

    int deleteById(Integer id);

    List<Map<String, Object>> queryUsersListMap();

    User queryUsersById(Integer id);

}
