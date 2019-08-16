package com.tengxt.springboottesting.mapper;

import com.tengxt.springboottesting.entity.SysLog;

import java.util.List;

public interface SysLogMapper {

    List<SysLog> findByName(String username);

    Integer save(SysLog sysLog);
}
