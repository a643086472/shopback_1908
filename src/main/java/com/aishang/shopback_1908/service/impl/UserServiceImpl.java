package com.aishang.shopback_1908.service.impl;

import com.aishang.shopback_1908.dao.UserMapper;
import com.aishang.shopback_1908.po.User;
import com.aishang.shopback_1908.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
