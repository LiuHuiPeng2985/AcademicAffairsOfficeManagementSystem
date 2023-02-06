package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务逻辑
 */
public class UserServiceImpl implements UserService {
    //调用UserDao的方法
    private UserDao userDao = new UserDaoImpl();

    /**
     * 登录
     */
    @Override
    public User login(String username, String password, String type) {
        User user = null;
        //查询对象
        user= userDao.select(username);
        //用户不为空,验证密码和身份
        if (user != null && user.getPassword().equals(password) && user.getType().equals(type)){
                return user;
            }
        return null;
    }

    /**
     * 注册
     */
    @Override
    public Integer addUser(String username, String password, String type) {
        Integer add = null;
        User user = null;
        Integer add1;
        try {
            user= userDao.select(username);
            if (user == null){
                add1 = userDao.addUser(username,password,type);
                return add1;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return add;
    }

    /**
     * 查看所有用户
     */
    @Override
    public List<User> searchUser() {
        List<User> users = new ArrayList<>();
        try {
            users = userDao.searchUser();
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 删除
     */
    @Override
    public Integer deleteUser(String username) {
        Integer result = 0;
        try {
            result = userDao.deleteUser(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
