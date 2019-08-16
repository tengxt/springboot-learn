package com.tengxt.springboottesting.service;

import com.tengxt.springboottesting.entity.SysLog;

import java.util.List;

public interface SysLogService {
    SysLog findByName(String username);

    Integer save(SysLog sysLog);
}
