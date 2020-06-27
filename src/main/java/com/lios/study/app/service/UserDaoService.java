package com.lios.study.app.service;

import com.lios.study.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaiguang
 * @date 2020/6/14
 */
@Service
public class UserDaoService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveUser(User user) {
        int row = jdbcTemplate.update("INSERT INTO USER (ID, NAME, PASSWORD) VALUES (?, ?, ?)",
                user.getId(), user.getName(), user.getPassword());


        return row == 1;
    }

    public User getUser(int id) {
        String sql = "SELECT `id`,`name` FROM USER WHERE `id` = ?";
        List<User> list = jdbcTemplate.query(sql, new Integer[]{id}, new BeanPropertyRowMapper<>(User.class));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public List<User> findAllUser() {
        String sql = "SELECT `id`,`name` FROM USER";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}