package com.hnisc.community.service.impl;

import com.hnisc.community.mapper.UserMapper;
import com.hnisc.community.model.User;
import com.hnisc.community.model.UserExample;
import com.hnisc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lh141
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectByExample(String token) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTokenEqualTo(token);
        List<User> users = userMapper.selectByExample(userExample);

        return users;
    }

    @Override
    public void createOrUpdateUser(User user) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);

        if (users.size() == 0) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtModified());
            userMapper.insert(user);
        } else {
            User dbUser = users.get(0);
            User updatUser = new User();
            //更新用户最新登录时间，用户头像，用户昵称，用户登录令牌
            updatUser.setGmtModified(System.currentTimeMillis());
            updatUser.setAvatarUrl(user.getAvatarUrl());
            updatUser.setName(user.getName());
            updatUser.setToken(user.getToken());

            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andIdEqualTo(dbUser.getId());

            userMapper.updateByExampleSelective(updatUser, userExample1);
        }
    }
}
