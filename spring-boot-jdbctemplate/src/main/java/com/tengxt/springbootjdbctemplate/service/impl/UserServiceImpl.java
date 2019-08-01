package com.tengxt.springbootjdbctemplate.service.impl;

import com.tengxt.springbootjdbctemplate.service.UserService;
import com.tengxt.springbootjdbctemplate.entity.User;
import com.tengxt.springbootjdbctemplate.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(User user) {
        String sql = "INSERT INTO user(name,sex) VALUES(?,?)";
        Object[] args = {user.getName(), user.getSex()};
        int[] argTypes = {Types.VARCHAR, Types.BIT};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE user SET name = ? , sex = ? WHERE id = ?";
        Object[] args = {user.getName(), user.getSex(), user.getId()};
        int[] argTypes = {Types.VARCHAR, Types.BIT, Types.INTEGER};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "DELETE FROM user WHERE id =?";
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Map<String, Object>> queryUsersListMap() {
        String sql = "SELECT id,name,sex FROM user";
        return this.jdbcTemplate.queryForList(sql);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public User queryUsersById(Integer id) {
        String sql = "SELECT id,name,sex FROM user WHERE id = ?";
        Object[] args = {id};
        int[] argTypes = {Types.INTEGER};
        //List<User> userList = this.jdbcTemplate.query(sql, args, argTypes, new UserMapper());
        List<User> userList = this.jdbcTemplate.query(sql, args, argTypes, new BeanPropertyRowMapper<>(User.class));
        if(null != userList && userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }
}
