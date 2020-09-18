package com.dubbo.indetity.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.dubbo.indetity.po.User;
import com.dubbo.indetity.service.TokenService;
import org.apache.dubbo.config.annotation.Service;

import java.util.Date;
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        try {
            token = JWT.create().withAudience(user.getUserId().toString()).withIssuedAt(start).withExpiresAt(end)
                    .sign(Algorithm.HMAC256(user.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }

        return token;
    }
}
