package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Employee;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface IEmployeeService extends IService<Employee> {
//    Page<Employee> findPage(Page<Employee> objectPage, Integer id, String employee_name, String post);
}
