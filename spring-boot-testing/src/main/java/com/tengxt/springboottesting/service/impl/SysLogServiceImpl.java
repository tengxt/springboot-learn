package com.tengxt.springboottesting.service.impl;

import com.tengxt.springboottesting.entity.SysLog;
import com.tengxt.springboottesting.mapper.SysLogMapper;
import com.tengxt.springboottesting.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLog findByName(String username) {
        SysLog sysLog = null;
        if(null != username && !"".equals(username)){
            List<SysLog> sysLogs = sysLogMapper.findByName(username);
            if(null != sysLogs && sysLogs.size() > 0){
                sysLog =  sysLogs.get(0);
            }
        }
        return sysLog;
    }

    @Override
    public Integer save(SysLog sysLog) {
        Integer res = null;
        if(null != sysLog){
            res = sysLogMapper.save(sysLog);
        }
        return res;
    }
}
