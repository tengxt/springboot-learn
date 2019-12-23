package com.tengxt.community.mapper;

import com.tengxt.community.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(account_id,name,token,gmt_create,gmt_modified) VALUES (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    int insert(User user);

    @Select("SELECT * FROM user WHERE token=#{token}")
    User findByToken(@Param("token") String token);
}
