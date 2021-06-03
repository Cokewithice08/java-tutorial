package cn.jast.spring.aop.api.BeanNameAutoProxyCreator;

import cn.jast.spring.aop.api.BeanNameAutoProxyCreator.component.HelloService;
import cn.jast.spring.aop.api.BeanNameAutoProxyCreator.component.PersonService;
import cn.jast.spring.aop.api.BeanNameAutoProxyCreator.component.PersonServiceImpl;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jast90 on 2021/6/3
 */
@Configuration
@ComponentScan("cn.jast.spring.aop.api.BeanNameAutoProxyCreator")
public class AppConfig {
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("*Service");
        beanNameAutoProxyCreator.setInterceptorNames("logInterceptor");
        return beanNameAutoProxyCreator;
    }

    @Bean
    public PersonService personService(){
        return new PersonServiceImpl();
    }

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
