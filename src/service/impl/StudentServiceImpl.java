package service.impl;

import dao.impl.StudentDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Student;
import entity.User;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDaoImpl studentDao = new StudentDaoImpl();

    /**
     * 学生查看自己成绩
     * @return
     */
    @Override
    public List<Student> searchAchievement(String username) {
        List<Student> student =null;
        try {
            student = studentDao.searchAchievement(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 修改老师信息
     * @return
     */
    @Override
    public Integer updateStudent(String username, String course, String score) {
        User user = null;
        Integer update = null;
        Student student = null;

        Integer update1;
        try {
            //查询user表
            UserDaoImpl userDao = new UserDaoImpl();
            user = userDao.select(username);

            student = studentDao.selectStudent(username);
            update = studentDao.updateStudent(username,course,score);
            if (user != null){
                if (student != null){
                    update1 = studentDao.updateStudent(username,course,score);
                    return update1;
                }else {
                    update1 = studentDao.addStudent(username,course,score);
                    return update1;
                }
            }else {
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

}
