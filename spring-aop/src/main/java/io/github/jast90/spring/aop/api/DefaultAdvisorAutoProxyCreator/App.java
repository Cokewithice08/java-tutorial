package io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator;

import io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator.component.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jast90 on 2021/6/3
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = context.getBean(HelloService.class);
        helloService.hello();
    }
}
