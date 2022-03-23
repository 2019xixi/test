package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.controller.dto.SysUserDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.SysUser;
import com.example.demo.service.ISysUserService;
import com.example.demo.service.impl.SysUserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public boolean login(@RequestBody SysUserDTO sysUserDTO){
        String username = sysUserDTO.getUsername();
        String password = sysUserDTO.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return false;
        }
        return sysUserService.login(sysUserDTO);
    }
}
