package com.msgsys.dao.impl;

import com.msgsys.dao.BaseDao;
import com.msgsys.dao.UserDao;
import com.msgsys.entity.User;

import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 14:25
 * 描述:
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int insert(User user) {
        String sql = "insert into t_user (username,password,email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public int update(User user) {
        String sql = "update t_user set username=?,password=?,email=? where id=?";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(),user.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from t_user where id=?";
        return update(sql, id);
    }

    @Override
    public List<User> queryAll() {
        String sql = "select * from t_user";
        return queryForList(User.class, sql);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select * from t_user where id=?";
        return queryForOne(User.class, sql, id);
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        String sql = "select * from t_user where username=? and password=?";
        return queryForOne(User.class, sql, user.getUsername(), user.getPassword());
    }
}
