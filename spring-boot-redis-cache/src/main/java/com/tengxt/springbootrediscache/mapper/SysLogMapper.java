package com.tengxt.springbootrediscache.mapper;

import com.tengxt.springbootrediscache.entity.SysLog;

public interface SysLogMapper {

    SysLog querySysLogById(Integer id);

    int update(String username, Integer id);

    int delete(Integer id);
}
