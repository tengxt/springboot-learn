package com.tengxt.springboottesting.entity;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {

    private static final long serialVersionUID = -6671635432348191843L;

    private Integer id;
    private String username;
    private String operation;
    private String time;
    private String method;
    private String ip;
    private Date createTime;
    private String params;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", time='" + time + '\'' +
                ", method='" + method + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                ", params='" + params + '\'' +
                '}';
    }
}
