package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {



//    @Resource
//    private IEmployeeService employeeService;
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    //新增或者修改
    @PostMapping
    public boolean save(@RequestBody Employee employee){
        return employeeServiceImpl.saveEmployee(employee);
    }

    //查询所有数据
    @GetMapping("/")
    public List<Employee> findAll(){
        return employeeServiceImpl.list();
    }

    //通过id删除数据
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return employeeServiceImpl.removeById(id);
    }

    //批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) { // [1,2,3]
        return employeeServiceImpl.removeByIds(ids);
    }

    //分页查询
    @GetMapping("/page")
    public IPage<Employee> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String employee_name,
                                    @RequestParam(defaultValue = "") Integer id,
                                    @RequestParam(defaultValue = "") String post
                                    ){
        IPage<Employee> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        if(!"".equals(employee_name)){
            queryWrapper.like("employee_name",employee_name);
        }
        if(id!=null) {
            queryWrapper.like("id", id);
        }
        if(!"".equals(post)){
            queryWrapper.like("post",post);
        }
        return employeeServiceImpl.page(page, queryWrapper);
    }

}
