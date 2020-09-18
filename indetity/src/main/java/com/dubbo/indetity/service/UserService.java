package com.dubbo.indetity.service;

import com.dubbo.indetity.po.User;

import java.util.List;

public interface UserService {
    /**
     * 通过用户名获取唯一用户
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName);

    /**
     * 根据条件获取用户
     * @param user
     * @return
     */
    public List<User> getUserSelective(User user);

    /**
     * 通过主键获取用户
     * @param userId
     * @return
     */
    public User getUserByUserId(Integer userId);

}
