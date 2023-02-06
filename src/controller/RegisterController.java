package controller;

/*
 * @author  LiuHuiPeng
 */


import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 */
@WebServlet(name = "RegisterController",urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        UserService userService = new UserServiceImpl();
//        userService.addUser(username,password,type);
        Integer a = userService.addUser(username,password,type);
        if (a != null){
            req.setAttribute("errorRegister","注册成功");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
//            resp.sendRedirect(req.getContextPath()+"/manager.jsp");
        }
        if (a == null) {
//            resp.sendRedirect(req.getContextPath()+"/register.jsp");
            req.setAttribute("errorRegister","账号存在，注册失败");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
       }
//        System.out.println(a);
    }
}
