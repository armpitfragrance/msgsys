package com.msgsys.service.impl;

import com.msgsys.dao.MessageDao;
import com.msgsys.dao.impl.MessageDaoImpl;
import com.msgsys.entity.Message;
import com.msgsys.service.MessageService;

import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 18:20
 * 描述:
 */
public class MessageServiceImpl implements MessageService {
    MessageDao messageDao = new MessageDaoImpl();
    @Override
    public List<Message> queryMessageByToUid(Integer toUid) {
        return messageDao.queryMessageByToUid(toUid);
    }

    @Override
    public Message queryMessageById(Integer id) {
        return messageDao.queryMessageById(id);
    }
}
