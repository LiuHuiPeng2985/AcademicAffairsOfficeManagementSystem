package controller;

/*
 * @author  LiuHuiPeng
 */

import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生界面成绩显示
 */
@WebServlet(name = "StudentSearchController",urlPatterns = "/studentSearchController")
public class StudentSearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取session对象
        HttpSession session1 = req.getSession();
        //得到session中存储的username
        String username = (String) session1.getAttribute("username");

        StudentService studentService = new StudentServiceImpl();
        List<Student> achievement = studentService.searchAchievement(username);
        if (achievement != null){
            req.setAttribute("achievement",achievement);
            req.getRequestDispatcher("/student.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/student.jsp");
        }
    }
}
