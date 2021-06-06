package io.github.jast90.spring.aop.api.ProxyFactoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jast90 on 2021/6/5
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getClass().getName());
        person.say();

        Hello hello = context.getBean("hello", Hello.class);
        hello.hello();
    }
}
