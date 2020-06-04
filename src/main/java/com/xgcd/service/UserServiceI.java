package com.xgcd.service;

import com.xgcd.entity.User;

import java.util.List;

public interface UserServiceI {
    List<User> selectUserList();
    User selectUserById(int id);
}
