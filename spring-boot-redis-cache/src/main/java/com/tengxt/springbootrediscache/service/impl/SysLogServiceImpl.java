package com.tengxt.springbootrediscache.service.impl;

import com.tengxt.springbootrediscache.entity.SysLog;
import com.tengxt.springbootrediscache.mapper.SysLogMapper;
import com.tengxt.springbootrediscache.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("sysLogService")
@CacheConfig(cacheNames = "sysLog")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    @Cacheable
    public SysLog querySysLogById(Integer id) {
        return sysLogMapper.querySysLogById(id);
    }

    @Override
    @CachePut(key = "#id")
    public int update(String username, Integer id) {
        return sysLogMapper.update(username, id);
    }

    @Override
    @CacheEvict(key = "#id")
    public int delete(Integer id) {
        return sysLogMapper.delete(id);
    }
}
