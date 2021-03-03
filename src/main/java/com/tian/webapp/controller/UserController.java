package com.tian.webapp.controller;

import com.tian.webapp.dao.UserDao;
import com.tian.webapp.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author David Tian
 * @desc
 * @since 2020-04-11 17:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/test")
    @ApiOperation(value = "test用户")
    public void test(){
        // 新增数据
        User user1 = new User();
        user1.setUsername("hangge");
        user1.setPassword("123456");
        int i1 = userDao.addUser(user1);
        System.out.println("插入一条数据>>>" + i1);

        // 修改数据
        User user2 = new User();
        user2.setId(1);
        user2.setPassword("888888");
        int i2 = userDao.updateUser(user2);
        System.out.println("更新一条数据>>>" + i2);

        // 删除数据
        int i3 = userDao.deleteUserById(120);
        System.out.println("删除一条数据>>>" + i3);

        // 查询单条数据
        User user4 = userDao.getUserById(1);
        System.out.println("查询1条数据>>>" + user4.toString());

        // 查询多条数据
        List<User> users = userDao.getAllUser();
        System.out.println("查询多条数据>>>" + users);

        return;
    }
}
