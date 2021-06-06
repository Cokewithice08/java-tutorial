package io.github.jast90.spring.aop.api.ProxyFactoryBean;

/**
 * Created by jast90 on 2021/6/5
 */
public class PersonImpl implements Person{
    @Override
    public void say() {
        System.out.println("Person impl");
    }
}
