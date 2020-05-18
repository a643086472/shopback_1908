package com.aishang.shopback_1908.service.impl;

import com.aishang.shopback_1908.dao.AdminuserMapper;
import com.aishang.shopback_1908.po.Adminuser;
import com.aishang.shopback_1908.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminuserMapper adminuserMapper;


    /**
     * @author 周城
     * @date 2020/1/7 16:50
     * @param 登录校验
     */
    @Override
    public Adminuser doLogin(Adminuser adminuser) {
        return adminuserMapper.doLogin(adminuser);
    }
}
