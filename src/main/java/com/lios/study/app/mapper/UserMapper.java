package com.lios.study.app.mapper;

import com.lios.study.app.models.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author liaiguang
 */
@Repository
public interface UserMapper extends Mapper<User> {
    /**
     * 存储用户数据到数据库
     * @param user
     * @return true=成功，false=失败
     */
    boolean saveUser(User user);

    /**
     * 通过用户名查找用户信息
     * @param name
     * @return User=成功，null=无此用户
     */
    User findUserByName(String name);

    /**
     * 通过用户名查找用户信息
     * @param userId
     * @return User=成功，null=无此用户
     */
    User findUserById(int userId);

    /**
     * 查找全部用户
     * @return List<User>=全部用户
     */
    List<User> getUserList();

    /**
     * 通过用户名删除用户
     * @param name
     * @return true=成功，false=失败
     */
    boolean deleteUserByName(String name);

    /**
     * 通过用户名更新用户密码
     * @param user
     * @return true=成功，false=失败
     */
    boolean updateUserByName(User user);

}
