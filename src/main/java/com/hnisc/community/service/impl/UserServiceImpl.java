package com.hnisc.community.service.impl;

import com.hnisc.community.mapper.UserMapper;
import com.hnisc.community.model.User;
import com.hnisc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lh141
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByToken(String token) {
        User user = userMapper.findByToken(token);
        return user;
    }

    @Override
    public void createOrUpdateUser(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());

        if (dbUser == null) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtModified());
            userMapper.inertUser(user);
        } else if (dbUser != null) {
            //更新用户最新登录时间，用户头像，用户昵称，用户登录令牌
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());

            userMapper.updateUser(dbUser);
        }
    }
}
