package com.tian.webapp.service;

import com.tian.webapp.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author David Tian
 * @desc
 * @since 2020-04-04 03:01
 */
@Service
public class TestService {

    /**
     * 注入dao
     */
    @Autowired
    private UserMapper usermapper;

    public void  add(String username,String password,int age){
        Date time = new Date();
        usermapper.adduser(username,password,age,time);
        System.out.println("==========");
    }
}
