package com.tengxt.springbootjdbctemplate.mapper;

import com.tengxt.springbootjdbctemplate.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 返回表对应的实体对象
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSex(resultSet.getByte("sex"));
        return user;
    }
}
