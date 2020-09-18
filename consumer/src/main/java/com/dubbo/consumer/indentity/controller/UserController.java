package com.dubbo.consumer.indentity.controller;

import com.dubbo.api.po.BaseResult;
import com.dubbo.consumer.indentity.util.TokenUtils;
import com.dubbo.indetity.annoation.UserLoginToken;
import com.dubbo.indetity.po.User;
import com.dubbo.indetity.service.TokenService;


import com.dubbo.indetity.service.UserService;

import org.apache.dubbo.common.json.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {
    @Reference
    UserService userService;
    @Reference
    TokenService tokenService;

    // 登录
    @ResponseBody
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public BaseResult login(@RequestBody User user,HttpServletResponse response, HttpServletRequest request) {
        BaseResult baseResult=new BaseResult();
        JSONObject jsonObject = new JSONObject();
        User basic=userService.getUserByUserName(user.getUserName());
        User userForBase = new User();
        userForBase.setUserId(basic.getUserId());
        userForBase.setUserName(basic.getUserName());
        userForBase.setPassword(basic.getPassword());
        if (!userForBase.getPassword().equals(user.getPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            baseResult.markSuccess("获取信息成功",jsonObject,null);

        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            baseResult.markSuccess("获取信息成功",token,null);


        }
        return baseResult;
    }
    /***
     * 这个请求需要验证token才能访问
     *
     * @author: qiaoyn
     * @date 2019/06/14
     * @return String 返回类型
     */
    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage(HttpServletResponse response, HttpServletRequest request) {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtils.getTokenUserId());

        return "您已通过验证";
    }
}

