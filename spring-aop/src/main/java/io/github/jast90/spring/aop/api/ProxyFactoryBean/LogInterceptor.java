package io.github.jast90.spring.aop.api.ProxyFactoryBean;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jast90 on 2021/6/5
 */
public class LogInterceptor implements MethodInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            invocation.proceed();
        }finally {
            logger.debug("LogInterceptor ....");
        }
        return null;
    }
}
