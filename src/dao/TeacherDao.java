package dao;

import entity.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> searchCurriculum(String username);

    //查找teacher表中有没有该老师
    Teacher selectTeacher(String username);
    //修改老师课程
    Integer updateTeacher(String username, String classes, String course, String time);
    //没有找到老师，则添加信息
    Integer addTeacher(String username, String classes, String course, String time);
}
