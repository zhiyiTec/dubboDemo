package com.dubbo.indetity.service;

import com.dubbo.indetity.po.User;

public interface TokenService {
    /**
     * 获取用户token
     * @param user
     * @return
     */
    public String getToken(User user);
}
