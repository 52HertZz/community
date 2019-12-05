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
}
