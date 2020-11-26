package com.msgsys.dao;

import com.msgsys.entity.User;

import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 14:22
 * 描述:
 */
public interface UserDao {
    public int insert(User user);
    public int update(User user);
    public int delete(Integer id);

    public List<User> queryAll();

    public User queryUserById(Integer id);

    public User queryUserByNameAndPassword(User user);

}
