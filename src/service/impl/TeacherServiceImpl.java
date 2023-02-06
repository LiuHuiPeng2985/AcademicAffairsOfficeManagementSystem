package service.impl;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Teacher;
import entity.User;
import javafx.beans.binding.Bindings;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherDaoImpl teacherDao = new TeacherDaoImpl();

    /**
     * 老师查看自己的课程
     * @return
     */
    @Override
    public List<Teacher> searchCurriculum(String username) {
        List<Teacher> teacher = null;
        try {
            teacher = teacherDao.searchCurriculum(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return teacher;

    }

    /**
     * 修改老师信息
     * @return
     */
    @Override
    public Integer updateTeacher(String username, String classes, String course, String time) {
        User user = null;
        Integer update = null;
        Teacher teacher = null;

        Integer update1;
        try {
            //查询user表
            UserDaoImpl userDao = new UserDaoImpl();
            user = userDao.select(username);

            teacher = teacherDao.selectTeacher(username);
            update = teacherDao.updateTeacher(username,classes,course,time);
            if (user != null){
                if (teacher != null){
                    update1 = teacherDao.updateTeacher(username,classes,course,time);
                    return update1;
                }else {
                    update1 = teacherDao.addTeacher(username,classes,course,time);
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
