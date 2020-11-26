package com.msgsys.service;

import com.msgsys.entity.User;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 15:39
 * 描述:
 */
public interface UserService {
    public int resister(User user);

    public User Login(User user);

}
