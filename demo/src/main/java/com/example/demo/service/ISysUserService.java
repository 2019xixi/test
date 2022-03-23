package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.controller.dto.SysUserDTO;
import com.example.demo.entity.SysUser;

public interface ISysUserService extends IService<SysUser> {
    boolean login(SysUserDTO sysUserDTO);
}
