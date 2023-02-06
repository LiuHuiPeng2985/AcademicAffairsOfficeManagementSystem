package dao;

import entity.Student;
import entity.Teacher;

import java.util.List;

public interface StudentDao {
    List<Student> searchAchievement(String username);

    //查找student表中有没有该学生
    Student selectStudent(String username);
    //修改学生成绩
    Integer updateStudent(String username, String course, String score);
    //没有找到学生，则添加信息
    Integer addStudent(String username, String course, String score);

}
