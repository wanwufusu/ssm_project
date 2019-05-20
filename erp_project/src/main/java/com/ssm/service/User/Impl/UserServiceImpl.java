package com.ssm.service.User.Impl;

import com.ssm.bean.User;
import com.ssm.mapper.UserMapper;
import com.ssm.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User findUserByPassword(String username,String password) {
        return userMapper.findUserByPassword(username,password);
    }
}
