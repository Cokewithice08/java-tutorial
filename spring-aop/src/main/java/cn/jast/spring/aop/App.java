package cn.jast.spring.aop;

import cn.jast.spring.aop.config.AppConfig;
import cn.jast.spring.aop.service.Hello1Service;
import cn.jast.spring.aop.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Hello1Service helloService = annotationConfigApplicationContext.getBean(Hello1Service.class);
        helloService.hello1();
    }
}
