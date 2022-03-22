package com.tolisso.bsmicro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Before("execution(* com.tolisso.bsmicro.controller.GreetingController.greeting(..))")
    public void logBefore(JoinPoint jp) {
        logger.info(jp.getSignature().getName() + " launched with args: " + Arrays.toString(jp.getArgs()));
    }
//
//
    @AfterReturning(pointcut = "execution(* com.tolisso.bsmicro.controller.GreetingController.greeting(..))", returning = "result")
    private void logAfter(JoinPoint jp, Object result) {
        logger.info(jp.getSignature().getName() + " result: " + result);
    }
}
