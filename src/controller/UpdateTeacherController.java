package controller;

/*
 * @author  LiuHuiPeng
 */

import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 老师信息修改
 */
@WebServlet(name = "UpdateTeacherController",urlPatterns = "/updateTeacherController")
public class UpdateTeacherController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String classes = req.getParameter("classes");
        String course = req.getParameter("course");
        String time = req.getParameter("time");

        TeacherService teacherService = new TeacherServiceImpl();
        Integer i = teacherService.updateTeacher(username,classes,course,time);
        if (i != null){
            req.setAttribute("errorUpdate","修改成功");
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }else{
            req.setAttribute("errorUpdate","修改失败，用户不存在");
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }
    }
}
