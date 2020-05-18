package com.aishang.shopback_1908.controller;

import com.aishang.shopback_1908.po.Adminuser;
import com.aishang.shopback_1908.service.AdminUserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;
    @Resource
    private HttpSession session;


    /**
     * @author 周城
     * @date 2020/1/7 16:48
     * @param 登录校验
     */
    @RequestMapping("/login")
    public Adminuser login(@RequestBody Adminuser adminuser){
        Adminuser result = adminUserService.doLogin(adminuser);
        if(result!=null){
            session.setAttribute("adminUser",result);
        }
        return result;
    }



}
