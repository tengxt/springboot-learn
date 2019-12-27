package com.tengxt.community.mapper;

import com.tengxt.community.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(account_id,name,token,gmt_create,gmt_modified,avatar_url) VALUES (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    int insert(User user);

    @Select("SELECT * FROM user WHERE token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findById(@Param("id") Integer id);

    @Select("SELECT * FROM user WHERE account_id=#{accountId}")
    List<User> findByAccId(@Param("accountId") String accountId);

    @Update("UPDATE user SET name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} WHERE id=#{id}")
    int update(User updateUser);
}
