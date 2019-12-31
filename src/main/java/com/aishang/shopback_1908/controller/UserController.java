package com.aishang.shopback_1908.controller;

import com.aishang.shopback_1908.po.User;
import com.aishang.shopback_1908.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/demo")
    public List<User> demo(){

        return userService.getAll();
    }

}
