package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;


public interface EmployeeMapper extends BaseMapper<Employee> {

//    @Select("SELECT * FROM employee")
//    List<Employee> findAll();

//    @Insert("INSERT INTO employee (employee_name, post) VALUES (#{employee_name}, #{post})")
//    int insert(Employee employee);

//    int update(Employee employee);
//
//    @Delete("delete from employee where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
    Page<Employee> findPage(Page<Employee> page, @Param("id") Integer id, @Param("employee_name") String employee_name, @Param("post") String post);
}
