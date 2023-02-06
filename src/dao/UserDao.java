package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 声明
     * 根据username来查询
     */
    User select(String username);

    /**
     * 注册
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
