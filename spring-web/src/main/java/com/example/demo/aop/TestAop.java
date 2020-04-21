package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangxuhao
 * @DATE 2020-04-21 16:32.
 */
@Aspect
@Component
public class TestAop {
  @Pointcut("@annotation(com.example.demo.annotation.TestCglib)")
  public void testPointcut(){

  }

  @Around("testPointcut()")
  public Object test(ProceedingJoinPoint point) throws Throwable {
    System.out.println("8888888888");
    return point.proceed();
  }
}
