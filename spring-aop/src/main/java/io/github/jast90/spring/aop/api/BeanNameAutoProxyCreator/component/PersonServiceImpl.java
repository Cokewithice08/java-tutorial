package io.github.jast90.spring.aop.api.BeanNameAutoProxyCreator.component;


/**
 * Created by jast90 on 2021/6/3
 */
public class PersonServiceImpl implements PersonService {
    @Override
    public void hello() {
        System.out.println("Hello");
    }
}
