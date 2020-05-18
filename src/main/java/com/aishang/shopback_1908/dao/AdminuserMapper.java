package com.aishang.shopback_1908.dao;

import com.aishang.shopback_1908.po.Adminuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;
@Mapper
public interface AdminuserMapper extends MyMapper<Adminuser> {

    /**
     * @author 周城
     * @date 2020/1/7 16:52
     * @param 登录校验
     */
    @Select("select * from adminuser where username=#{username} and password=#{password}")
    Adminuser doLogin(Adminuser adminuser);
}