package com.hnisc.community.service;

import com.hnisc.community.model.User;

/**
 * @author lh141
 */
public interface UserService {

    User findByToken(String token);

    void createOrUpdateUser(User user);
}
