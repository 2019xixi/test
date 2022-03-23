package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String employee_name;
    private String post;
}


