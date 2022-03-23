package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements IEmployeeService {

    public boolean saveEmployee(Employee employee){
        if(employee.getId() == null){
            return save(employee);  // mybatis-plus提供的方法，插入数据
        }else{
            return updateById(employee);
        }
    }
//    @Override
//    public Page<Employee> findPage(Page<Employee> page, Integer id, String employee_name, String post) {
//    return EmployeeMapper.findPage(page, id, employee_name, post);
//    }
}
