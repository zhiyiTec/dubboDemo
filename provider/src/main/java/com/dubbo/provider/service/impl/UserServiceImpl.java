package com.dubbo.provider.service.impl;
import com.dubbo.provider.po.UserAddress;
import com.dubbo.provider.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Service//暴露服务
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "北京市昌平区", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区", "1", "王老师", "010-56253825", "N");
        return Arrays.asList(address1,address2);
    }

    @Override
    public String getMsg() {
        return "这是提供者推送的信息";
    }
}