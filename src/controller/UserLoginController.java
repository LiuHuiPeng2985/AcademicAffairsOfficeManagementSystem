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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户登录
 */
@WebServlet(name = "UserLoginController",urlPatterns = "/login")
public class UserLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String inputVcode = req.getParameter("inputVcode");
        String type = req.getParameter("type");

        //存储用户登录的账号
        HttpSession session1 = req.getSession();
        session1.setAttribute("username",username);

        //获取session对象
        HttpSession session = req.getSession();
        //得到session中存储的验证码
        String codes = (String) session.getAttribute("codes");
        //校验验证码
        if (codes != null && codes.equals(inputVcode)){
            //验证码正确，调用service业务逻辑实现登录
            UserService userService = new UserServiceImpl();
            User user = userService.login(username,password,type);
            if (user != null){
                //页面显示XX
                req.setAttribute("key",username);
                //判断身份是哪个
                if (type.equals("student")){
                    req.getRequestDispatcher("/studentSearchController").forward(req,resp);
                } else if (type.equals("teacher")){
                    req.getRequestDispatcher("/teacherSearchController").forward(req,resp);
                } else if (type.equals("manager")){
                    req.getRequestDispatcher("/manager.jsp").forward(req,resp);
                }
            }else {
                req.setAttribute("errorLogin","账号、密码错误或身份不正确，登录失败");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("errorLogin","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
