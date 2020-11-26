package com.msgsys.servlet;

import com.msgsys.entity.Message;
import com.msgsys.entity.User;
import com.msgsys.service.MessageService;
import com.msgsys.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 16:20
 * 描述:
 */
@WebServlet("/message.do")
public class MessageServlet extends BaseServlet {
    MessageService messageService = new MessageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void queryMessageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Message> messageList = messageService.queryMessageByToUid(user.getId());
        session.setAttribute("messageList", messageList);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
