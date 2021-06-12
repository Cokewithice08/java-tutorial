package io.github.jast90.spring.ioc;

import io.github.jast90.spring.ioc.bean.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloService helloService = context.getBean("helloService", HelloService.class);
        helloService.hello();

    }
}
