package cn.jast.spring.aop.usage;

import cn.jast.spring.aop.usage.config.AppConfig;
import cn.jast.spring.aop.usage.service.HelloService;
import cn.jast.spring.aop.usage.service.sub.Hello1Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = annotationConfigApplicationContext.getBean(HelloService.class);
        helloService.hello();
        Hello1Service hello1Service = annotationConfigApplicationContext.getBean(Hello1Service.class);
        hello1Service.hello1();

//        MyAnnotationComponent myAnnotationComponent = annotationConfigApplicationContext.getBean(MyAnnotationComponent.class);
//        myAnnotationComponent.helloMyAnnotation();
    }
}
