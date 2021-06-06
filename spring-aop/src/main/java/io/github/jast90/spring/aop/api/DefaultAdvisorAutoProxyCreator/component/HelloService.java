package io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator.component;

import org.springframework.stereotype.Service;

/**
 * Created by jast90 on 2021/6/3
 */
@Service
public class HelloService {
    public void hello(){
        System.out.println("Hello");
    }
}
