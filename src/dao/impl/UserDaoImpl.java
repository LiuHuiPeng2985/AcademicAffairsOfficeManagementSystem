package dao.impl;

import dao.UserDao;
import entity.Student;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //执行SQL语句
    private QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
    /**
     * 实现查询
     * @param username
     * @return
     */
    @Override
    public User select(String username) {
        String sql = "select * from user where username = ?";
        User user = null;
        //BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中
        try {
            user = queryRunner.query(sql,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 注册
     */
    @Override
    public Integer addUser(String username, String password, String type) {
        String sql = "insert into user(username,password,type) values(?,?,?)";
        Integer adduser = null;
        try {
            adduser =  queryRunner.update(sql,username,password,type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adduser;
    }

    /**
     * 查看
     */
    @Override
    public List<User> searchUser() {
        String sql ="select * from user";
        List<User> user = null;
        try {
            user = queryRunner.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return user;
    }

    /**
     * 删除
     */
    @Override
    public Integer deleteUser(String username) {
        String sql = "delete from user where username = ?";
        Integer delete = 0;
        try {
            delete = queryRunner.update(sql,username);
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return delete;
    }
}
