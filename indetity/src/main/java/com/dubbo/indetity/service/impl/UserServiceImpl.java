package com.dubbo.indetity.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dubbo.indetity.mapper.UserMapper;
import com.dubbo.indetity.po.User;
import com.dubbo.indetity.service.TokenService;
import com.dubbo.indetity.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUserName(String userName) {
        User user=userMapper.getUserByName(userName);
        return user;
    }

    @Override
    public List<User> getUserSelective(User user) {
        return userMapper.getUserSelective(user);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.getUserByPrimary(userId);
    }
}
