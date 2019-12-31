package com.aishang.shopback_1908.dao;

import com.aishang.shopback_1908.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper<User> {

    @Select("select * from user")
    List<User> getAll();
}