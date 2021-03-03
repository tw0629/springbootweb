
package com.tian.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.List;

/**
 * @author David Tian
 * @desc
 * @since 2020-03-21 13:02
 *
*/
@Aspect
public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("方法 " + methodName + "开始：" + args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法 " + methodName + "结束");
    }

    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法 " + methodName + "结果：" + result);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法 " + methodName + "异常：" + e);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try {
            //前置通知
            System.out.println("开始");
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("返回:" + result);
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("Exception: ");
            throwable.printStackTrace();
        }
        //后置通知
        System.out.println("end");

        return result;
    }
}