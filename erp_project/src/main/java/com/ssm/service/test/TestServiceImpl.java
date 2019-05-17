package com.ssm.service.test;

import com.ssm.bean.User;
import com.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/17
 * @since 1.0.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
