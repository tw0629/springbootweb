package com.tian.webapp.dao;

import com.tian.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author David Tian
 * @desc
 * @since 2020-04-11 17:47
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 新增数据
    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO user(username, password, age ,date_create) VALUE (?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getAge(), user.getDateCreate());
    }

    // 修改数据
    public int updateUser(User user) {
        return jdbcTemplate.update("UPDATE user SET username=?, password=? WHERE id=?",
                user.getUsername(), user.getPassword(), user.getId());
    }

    // 删除数据
    public int deleteUserById(Integer id) {
        return jdbcTemplate.update("DELETE FROM user WHERE id=?", id);
    }

    // 获取单条数据
    public User getUserById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id=?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    // 获取多条数据
    public List<User> getAllUser() {
        return jdbcTemplate.query("SELECT * FROM user",
                new BeanPropertyRowMapper<>(User.class));
    }
}