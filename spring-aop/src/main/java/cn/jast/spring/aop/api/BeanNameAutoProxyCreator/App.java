package cn.jast.spring.aop.api.BeanNameAutoProxyCreator;

import cn.jast.spring.aop.api.BeanNameAutoProxyCreator.component.HelloService;
import cn.jast.spring.aop.api.BeanNameAutoProxyCreator.component.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jast90 on 2021/6/3
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);
        System.out.println(personService.getClass().getName());
        HelloService helloService = context.getBean(HelloService.class);
        personService.hello();
        System.out.println(helloService.getClass().getName());
    }

}
