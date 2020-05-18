package com.aishang.shopback_1908.service;

import com.aishang.shopback_1908.po.Adminuser;

public interface AdminUserService {
    /**
     * @author 周城
     * @date 2020/1/7 16:49
     * @param 登录校验
     */
    Adminuser doLogin(Adminuser adminuser);
}
