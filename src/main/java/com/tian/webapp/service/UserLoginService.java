package com.tian.webapp.service;

import com.tian.webapp.dao.UserMapper;
import com.tian.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

/**
 * @author David Tian
 * @desc
 * @since 2020-04-04 02:11
 */
@Service
public class UserLoginService {

    /**
     * 注入dao
     */
    @Autowired
    private UserMapper usermapper;

    @Autowired
    private TestService testService;



    //用户登录
    public User userLogin(String username,String password){
        User user = usermapper.userlogin(username,password);
        return user;
    }

    //注册新用户
    @Transactional(rollbackFor = Exception.class)//顺便测试事务传播
    public int adduser(String username,String password,int age){

        //add(username, password, age);
        testService.add(username, password, age);

        try {
            if(age == 2){
                age = 1/0;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if(age == 8){
                age = 1/0;
            }

        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//就是这一句了，加上之后，如果doDbStuff2()抛了异常,                                            //doDbStuff1()是会回滚的
        }

        return age;
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }

    public void  add(String username,String password,int age){
        usermapper.adduser(username,password,age,new Date());
        System.out.println("==========");
    }

}