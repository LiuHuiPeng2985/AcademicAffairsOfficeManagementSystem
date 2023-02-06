package dao.impl;

import dao.StudentDao;
import entity.Student;
import entity.Teacher;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    //执行SQL语句
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
    /**
     * 学生查看自己成绩
     * @return
     */
    @Override
    public List<Student> searchAchievement(String username) {
        String sql = "select * from student where username=?";
        try {
             return queryRunner.query(sql,new BeanListHandler<>(Student.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查找student表中有没有该学生
    @Override
    public Student selectStudent(String username) {
        String sql = "select * from student where username = ?";
        Student student = null;
        try {
            student = queryRunner.query(sql,new BeanHandler<>(Student.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    //修改学生成绩
    @Override
    public Integer updateStudent(String username, String course, String score) {
        String sql = "update student set course=?,score=? where username=?";
        Integer update = null;
        try {
            update = queryRunner.update(sql,course,score,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    //没有找到学生，则添加信息
    @Override
    public Integer addStudent(String username, String course, String score) {
        String sql = "insert into student(username,course,score) values(?,?,?)";
        Integer addStudent = null;
        try {
            addStudent = queryRunner.update(sql,username,course,score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addStudent;
    }
}
