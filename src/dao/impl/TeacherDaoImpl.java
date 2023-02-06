package dao.impl;

import dao.TeacherDao;
import entity.Teacher;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    //执行SQL语句
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());

    /**
     * 老师查看课程
     * @return
     */
    @Override
    public List<Teacher> searchCurriculum(String username) {
        String sql = "select * from teacher where username=?";
        try {
            return queryRunner.query(sql,new BeanListHandler<>(Teacher.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查找teacher表中有没有该老师
    @Override
    public Teacher selectTeacher(String username) {
        String sql = "select * from teacher where username = ?";
        Teacher teacher = null;
        try {
            teacher = queryRunner.query(sql,new BeanHandler<>(Teacher.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
    //修改老师课程
    @Override
    public Integer updateTeacher(String username, String classes, String course, String time) {
        String sql = "update teacher set classes=?,course=?,time=? where username=?";
        Integer update = null;
        try {
            update = queryRunner.update(sql,classes,course,time,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    //没有找到老师，则添加信息
    @Override
    public Integer addTeacher(String username, String classes, String course, String time) {
        String sql = "insert into teacher(username,classes,course,time) values(?,?,?,?)";
        Integer addTeacher = null;
        try {
            addTeacher = queryRunner.update(sql,username,classes,course,time);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addTeacher;
    }

}
