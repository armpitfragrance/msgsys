package com.msgsys.dao;

import com.msgsys.entity.Message;

import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 15:14
 * 描述:
 */
public interface MessageDao {
    public int insert(Message message);
    public int update(Message message);
    public int delete(Integer id);

    public List<Message> queryAll();

    public Message queryMessageById(Integer id);

    public List<Message> queryMessageByToUid(Integer toUid);
}
