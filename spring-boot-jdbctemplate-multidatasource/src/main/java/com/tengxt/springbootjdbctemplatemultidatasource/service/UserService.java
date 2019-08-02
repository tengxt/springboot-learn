package com.tengxt.springbootjdbctemplatemultidatasource.service;

import com.tengxt.springbootjdbctemplatemultidatasource.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> queryUser01All();

    List<User> queryUser02All();
}
