package service;

import entity.Student;

import java.util.List;

public interface StudentService {

    //根据不同的学生页面给出不同的成绩
    List<Student> searchAchievement(String username);
    //修改学生成绩信息
    Integer updateStudent(String username, String course, String score);
}
