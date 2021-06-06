package io.github.jast90.spring.aop.api.proxyFactory;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before log");
    }
}
