package com.tengxt.springbootaoplog.service.impl;

import com.tengxt.springbootaoplog.entity.SysLog;
import com.tengxt.springbootaoplog.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveSysLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("INSERT INTO sys_log(username,operation,time,method,ip,createTime,params)");
        sql.append("VALUES(:username,:operation,:time,:method,:ip,:createTime,:params)");

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        return namedParameterJdbcTemplate.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
    }
}
