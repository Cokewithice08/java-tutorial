package io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator.component;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractGenericPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Created by jast90 on 2021/6/3
 */
public class MyAdvisor extends AbstractGenericPointcutAdvisor {

    private NameMatchMethodPointcut nameMatchMethodPointcut ;

    public MyAdvisor() {
        nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.addMethodName("*Service");
    }

    @Override
    public Pointcut getPointcut() {
        return nameMatchMethodPointcut;
    }
}
