package com.tengxt.springbootmybatismultidatasource.mapper;



import com.tengxt.springbootmybatismultidatasource.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOneMapper {

    List<User> queryUserOneAll();
}
