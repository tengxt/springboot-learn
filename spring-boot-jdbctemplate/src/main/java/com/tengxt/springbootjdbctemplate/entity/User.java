package com.tengxt.springbootjdbctemplate.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -4367019591191910909L;

    private Integer id;

    private String name;

    private byte sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }
}
