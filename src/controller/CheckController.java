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
import java.util.List;

/**
 * 查看
 */
@WebServlet(name = "CheckController",urlPatterns = "/checkController")
public class CheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserService userService = new UserServiceImpl();
        List<User> see = userService.searchUser();
        req.setAttribute("see",see);
        req.getRequestDispatcher("/check.jsp").forward(req,resp);
    }
}
