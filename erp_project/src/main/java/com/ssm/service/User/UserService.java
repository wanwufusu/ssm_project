package com.ssm.service.User;

import com.ssm.bean.User;

public interface UserService {
    User findUserByUsername(String username);

    User findUserByPassword(String username,String password);
}
