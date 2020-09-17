package com.dubbo.consumer.consumer.controller;

import com.dubbo.api.po.BaseResult;
import com.dubbo.provider.po.UserAddress;
import com.dubbo.provider.service.OrderService;
import com.dubbo.provider.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class OrderController {

    @Reference
    OrderService orderService;
    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/initOrder",method = RequestMethod.POST)
    public List<UserAddress> initOrder(@RequestParam("uid")String userId) {
        return orderService.initOrder(userId);
    }
    @ResponseBody
    @RequestMapping(value = "/getMsg",method = RequestMethod.POST)
    public BaseResult getMsg(@RequestParam("uid")String userId) {
        BaseResult baseResult=new BaseResult();
        String re=userService.getMsg();
        baseResult.markSuccess("获取成功",re,null);
        return baseResult;
    }
}