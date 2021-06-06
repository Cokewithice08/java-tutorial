package io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator.component;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by jast90 on 2021/6/3
 */
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Before...");
        Object proceed = invocation.proceed();
        return proceed;
    }
}
