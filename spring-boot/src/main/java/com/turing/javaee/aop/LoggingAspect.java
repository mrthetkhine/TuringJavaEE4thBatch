package com.turing.javaee.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.turing.javaee.controller.HelloController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(* com.turing.javaee.controller.*.*(..))")
    public void repositoryMethods() {};

    @Before("repositoryMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.info("AOP Logging Before " + methodName);
    }
    
    @After("repositoryMethods()")
    public void afterMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.info("AOP Logging After " + methodName);
    }
    
    @AfterReturning(value = "repositoryMethods()", returning = "entity")
    public void logMethodCall(JoinPoint jp, Object entity) throws Throwable {
    	String methodName = jp.getSignature().getName();
    	log.info("AOP Logging After Returning " +methodName+" value =>" + entity);
    }
    @Around("repositoryMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        log.info("Execution of " + methodName + " took " + 
          TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return retval;
    }
    
    @AfterThrowing(value="repositoryMethods()",throwing="ex")
    public void logAfterThrowing(Exception ex)throws Throwable {

        log.error("Target Method resulted into exception "+ex.getMessage());
       
    }
}
