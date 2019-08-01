package com.tengxt.springbootmybatis.mapper;

import com.tengxt.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

//@Component
//@Mapper
public interface UserMapper {
    //@Insert("INSERT INTO user(name,sex) VALUES (#{name}, #{sex})")
    int save(User user);
    //@Update("UPDATE user SET name=#{name},sex=#{sex} WHERE id=#{id}")
    int update(User user);
    //@Delete("DELETE FROM user WHERE id=#{id}")
    int deleteById(Integer id);
    //@Select("SELECT id,name,sex FROM user WHERE id=#{id}")
    //@Results(id="User",value = {
    //        @Result(property = "id", column = "id", javaType = Integer.class),
    //        @Result(property = "name", column = "name", javaType = String.class),
    //        @Result(property = "sex", column = "sex", javaType = Byte.class)
    //})
    User queryById(Integer id);

}
