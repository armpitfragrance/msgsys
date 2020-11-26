package com.msgsys.service;

import com.msgsys.entity.Message;

import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 18:18
 * 描述:
 */
public interface MessageService {
    //根据收信人id查询邮件
    public List<Message> queryMessageByToUid(Integer toUid);

    public Message queryMessageById(Integer id);

}
