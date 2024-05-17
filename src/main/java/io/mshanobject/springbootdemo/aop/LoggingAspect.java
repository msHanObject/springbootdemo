package io.mshanobject.springbootdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    // [모든 returnType] [package-name].[모든 Controller].[모든 메서드](모든 파라미터)를 실행하기 전에 Point-Cut 하여 Weaving 함
    @Before("execution(* io.mshanobject.springbootdemo.controller.*Controller.*(..))")
    public void logging(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        log.debug("{}.{}()에서 로깅합니다.", className, methodName);
    }
}
