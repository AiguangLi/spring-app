package com.lios.study.app.service.impl;

import com.lios.study.app.mapper.UserMapper;
import com.lios.study.app.models.User;
import com.lios.study.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaiguang
 * @date 2020/6/27
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(User user) {
        user.setId((int)(System.currentTimeMillis() / 1000));
        return userMapper.saveUser(user);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public User findUserById(int userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public boolean deleteUserByName(String name) {
        return userMapper.deleteUserByName(name);
    }

    @Override
    public boolean updateUserByName(User user) {
        return userMapper.updateUserByName(user);
    }
}