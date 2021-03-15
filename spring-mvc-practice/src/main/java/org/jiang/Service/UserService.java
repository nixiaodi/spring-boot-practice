package org.jiang.Service;

import org.jiang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/3/15
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void addUser() {
        userMapper.addUser();
    }
}
