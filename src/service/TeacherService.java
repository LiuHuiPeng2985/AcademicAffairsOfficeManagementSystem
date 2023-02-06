package service;

import entity.Teacher;

import java.util.List;

public interface TeacherService {

    //根据不同的老师给出不同的课表
    List<Teacher> searchCurriculum(String username);
    //修改老师课程信息
    Integer updateTeacher(String username, String classes, String course, String time);
}
