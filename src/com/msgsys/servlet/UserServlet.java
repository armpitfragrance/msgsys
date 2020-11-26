package com.msgsys.servlet;

import com.msgsys.entity.User;
import com.msgsys.service.UserService;
import com.msgsys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：Zhh
 * 日期: 2020/11/26 14:41
 * 描述:
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //注册
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User(username, password, email);
        int result = userService.resister(user);
        System.out.println(result);
        resp.sendRedirect("/login.jsp");

    }

    //登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        String tokenConfirm = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String token = req.getParameter("token");
        if (token.equalsIgnoreCase(tokenConfirm)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            User user = userService.Login(new User(username, password, email));
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                req.getRequestDispatcher("/message.do?action=queryMessageList").forward(req, resp);
            } else {
                resp.sendRedirect("/login.jsp");
            }
        } else {
            resp.getWriter().print("<script>alert('验证码错误')</script>");
            resp.setHeader("refresh","1;URL=login.jsp");
        }


    }
}
