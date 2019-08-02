package com.tengxt.springbootjdbctemplatemultidatasource.service.impl;

import com.tengxt.springbootjdbctemplatemultidatasource.entity.User;
import com.tengxt.springbootjdbctemplatemultidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;

    @Resource(name = "jdbcTemplateTwo")
    private JdbcTemplate jdbcTemplateTwo;

    @Override
    public List<User> queryUser01All() {
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplateOne.query(sql, new BeanPropertyRowMapper<>(User.class));
        if(null != userList && userList.size() > 0){
            return userList;
        }
        return null;
    }

    @Override
    public List<User> queryUser02All() {
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplateTwo.query(sql, new BeanPropertyRowMapper<>(User.class));
        if(null != userList && userList.size() > 0){
            return userList;
        }
        return null;
    }
}
