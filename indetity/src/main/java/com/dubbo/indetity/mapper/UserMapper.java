package com.dubbo.indetity.mapper;

import com.dubbo.indetity.po.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUserSelective(User user);

    public User getUserByPrimary(Integer userId);

    public User getUserByName(String userName);
}
