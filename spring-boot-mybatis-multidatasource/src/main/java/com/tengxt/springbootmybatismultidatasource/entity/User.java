package com.tengxt.springbootmybatismultidatasource.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -4755538634729378715L;

    private Integer id;
    private String name;
    private boolean sex;

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
