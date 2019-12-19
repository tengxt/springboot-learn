package com.tengxt.cache.service;

import com.tengxt.cache.bean.Department;
import com.tengxt.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /*@Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门编号：" + id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }*/


    public Department getDeptById(Integer id){
        System.out.println("查询部门编号：" + id);
        Department department = departmentMapper.getDeptById(id);
        // 缓存
        redisTemplate.opsForValue().set("dept:" + id, department);
        return department;
    }
}
