package com.xgcd.service.impl;

import com.xgcd.entity.User;
import com.xgcd.mapper.UserMapper;
import com.xgcd.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
