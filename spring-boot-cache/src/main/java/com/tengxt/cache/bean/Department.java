package com.tengxt.cache.bean;

import java.io.Serializable;

public class Department implements Serializable {

    private Integer id;
    private String department;

    public Department() {

    }

    public Department(Integer id, String department) {
        this.id = id;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
