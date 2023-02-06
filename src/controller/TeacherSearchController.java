package controller;

/*
 * @author  LiuHuiPeng
 */

import entity.Student;
import entity.Teacher;
import service.StudentService;
import service.TeacherService;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 老师课程页面
 */
@WebServlet(name = "TeacherSearchController",urlPatterns = "/teacherSearchController")
public class TeacherSearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session1 = req.getSession();
        String username = (String) session1.getAttribute("username");

        TeacherService teacherService = new TeacherServiceImpl();
        List<Teacher> curriculum = teacherService.searchCurriculum(username);
        if (curriculum != null){
            req.setAttribute("curriculum",curriculum);
            req.getRequestDispatcher("/teacher.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/teacher.jsp");
        }

    }
}
