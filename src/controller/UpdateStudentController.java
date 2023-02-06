package controller;

/*
 * @author  LiuHuiPeng
 */


import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学生信息修改
 */
@WebServlet(name = "UpdateStudentController",urlPatterns = "/updateStudentController")
public class UpdateStudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String course = req.getParameter("course");
        String score = req.getParameter("score");

        StudentService studentService = new StudentServiceImpl();
        Integer i = studentService.updateStudent(username,course,score);
        if (i != null){
            req.setAttribute("errorUpdate","修改成功");
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }else{
            req.setAttribute("errorUpdate","修改失败，用户不存在");
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }
    }
}
