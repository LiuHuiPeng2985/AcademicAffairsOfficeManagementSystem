package controller;

/*
 * @author  LiuHuiPeng
 */

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除
 */
@WebServlet(name = "DeleteUserController",urlPatterns = "/deleteUserController")
public class DeleteUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        UserService userService = new UserServiceImpl();
        Integer delete = userService.deleteUser(username);
        if (delete != 0){
            req.setAttribute("delete","已删除，可进入查看界面确认");
            req.getRequestDispatcher("/delete.jsp").forward(req,resp);
        }else {
            req.setAttribute("delete","账号不存在，删除失败");
            req.getRequestDispatcher("/delete.jsp").forward(req,resp);
        }
    }
}
