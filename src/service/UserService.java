package service;

import entity.User;

import java.util.List;

public interface UserService {
    /**
     * 登录方法的声明
     */
    User login(String username, String password, String type);

    /**
     * 用户注册
     */
    Integer addUser(String username, String password, String type);

    /**
     * 查看
     */
    List<User> searchUser();

    /**
     * 删除
     */
    Integer deleteUser(String username);
}
