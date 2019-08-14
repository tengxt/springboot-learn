package com.tengxt.springbootrediscache.service;

import com.tengxt.springbootrediscache.entity.SysLog;

public interface SysLogService {

    SysLog querySysLogById(Integer id);

    int update(String username, Integer id);

    int delete(Integer id);
}
