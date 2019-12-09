package com.hnisc.community.service;

import com.hnisc.community.model.User;

import java.util.List;

/**
 * @author lh141
 */
public interface UserService {

    List<User> selectByExample(String token);

    void createOrUpdateUser(User user);
}
