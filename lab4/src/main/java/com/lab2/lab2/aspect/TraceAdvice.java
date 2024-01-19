package com.lab2.lab2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Aspect
@Configuration
public class TraceAdvice {

    @Autowired
    LoggerService loggerService;

    static String defaultUser = "Collin";

    @Before("execution(* com.lab2.lab2.service.impl.*.*(..))")
    public void traceBeforeComment(JoinPoint joinpoint) {
        Logger logger = new Logger(LocalDateTime.now(), defaultUser, joinpoint.getSignature().getName());
        loggerService.addLog(logger);
    }

    @Around("execution(* com.lab2.lab2.service.impl..*.*(..))")
    public Object profile (ProceedingJoinPoint call) throws Throwable{
        StopWatch clock = new StopWatch("");
        clock.start(call.toShortString());
        Object object= call.proceed();
        clock.stop();
        System.out.println(clock.prettyPrint());
        return object;
    }



}
