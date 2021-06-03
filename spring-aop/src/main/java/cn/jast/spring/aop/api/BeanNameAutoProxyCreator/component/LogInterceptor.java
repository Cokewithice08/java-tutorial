package cn.jast.spring.aop.api.BeanNameAutoProxyCreator.component;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

/**
 * Created by jast90 on 2021/6/3
 */
@Service
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Before...");
        Object proceed = invocation.proceed();
        return proceed;
    }
}
