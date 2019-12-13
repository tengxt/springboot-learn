package com.tengxt.cache.mapper;

import com.tengxt.cache.bean.SysLog;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SysLogMapper {

    @Select("SELECT * FROM sys_log WHERE id=#{id}")
    public SysLog getLogById(Integer id);


    @Update("UPDATE sys_log SET username=#{username}, operation=#{operation}, " +
            "time=#{time}, method=#{method}, ip=#{ip}, createTime=#{createTime}, " +
            "params=#{params} WHERE id=#{id}")
    public void updateLog(SysLog sysLog);

    @Delete("DELETE FROM sys_log WHERE id=#{id}")
    public void deleteLogById(Integer id);

    @Insert("INSERT INTO sys_log(username,operation,time,method,createTime,params) " +
            "VALUES (#{username},#{operation},#{time},#{method},#{createTime},#{params}")
    public void insertLog(SysLog sysLog);

    @Select("SELECT * FROM sys_log WHERE username=#{name}")
    public SysLog getSysLogByName(String name);
}
