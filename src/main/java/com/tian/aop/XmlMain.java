package com.tian.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author David Tian
 * @desc
 * @since 2020-03-21 14:15
 */
public class XmlMain {

    public static void main(String[] args) {

        // 方式一
        /*ApplicationContext context = new ClassPathXmlApplicationContext("config/aop.xml");
        Arithmetic calculator = (Arithmetic)context.getBean("calculator");
        int result = calculator.add(1, 2);
        System.out.println("=======> "+result);*/


        //会报错:Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy4 cannot be cast to com.tian.web.aop.Calculator
        //Arithmetic calculator = (Calculator)context.getBean("calculator");
        //Java代理不可以对类进行代理，只能针对接口代理。


        // 方式二 但是日志不生效
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
        Arithmetic calculator2 = (Arithmetic)context2.getBean("calculator");
        int result2 = calculator2.add(1, 2);
        System.out.println("=======> "+result2);
    }

}
