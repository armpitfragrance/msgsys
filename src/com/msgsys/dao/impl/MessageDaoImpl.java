package com.msgsys.dao.impl;

import com.msgsys.dao.BaseDao;
import com.msgsys.dao.MessageDao;
import com.msgsys.entity.Message;

import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 15:15
 * 描述:
 */
public class MessageDaoImpl extends BaseDao implements MessageDao {

    @Override
    public int insert(Message message) {
        String sql = "insert into t_msg (fromUid,toUid,mTitle,mContent,isRead,createTime) values(?,?,?,?,?,?)";
        return update(sql, message.getFromUid(), message.getToUid(), message.getmTitle(), message.getmContent(), message.getIsRead(), message.getCreateTime());
    }

    @Override
    public int update(Message message) {
        String sql = "update t_msg set fromUid=?,toUid=?,mTitle=?,mContent=?,isRead=?,createTime=? where id=?";
        return update(sql, message.getFromUid(), message.getToUid(), message.getmTitle(), message.getmContent(), message.getIsRead(), message.getCreateTime(), message.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from t_msg where id=?";
        return update(sql, id);
    }

    @Override
    public List<Message> queryAll() {
        String sql = "select * from t_msg";
        return queryForList(Message.class, sql);
    }

    @Override
    public Message queryMessageById(Integer id) {
        String sql = "select * from t_msg where id=?";

        return queryForOne(Message.class, sql, id);
    }

    @Override
    public List<Message> queryMessageByToUid(Integer toUid) {
        String sql = "select * from t_msg where toUid=?";
        return queryForList(Message.class, sql,toUid);
    }


}
