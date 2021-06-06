package io.github.jast90.spring.aop.api.ProxyFactoryBean;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jast90 on 2021/6/5
 */
@Configuration
public class AppConfig {

    @Bean
    public PersonImpl personImpl(){
        return new PersonImpl();
    }

    @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }

    @Bean
    public ProxyFactoryBean person() throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[]{Person.class});
        proxyFactoryBean.setTargetName("personImpl");
        proxyFactoryBean.setInterceptorNames("logInterceptor");
        return proxyFactoryBean;
    }

    @Bean
    public Hello helloTarget(){
        return new Hello();
    }

    @Bean
    public ProxyFactoryBean hello(){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyTargetClass(true);
        proxyFactoryBean.setTargetClass(Hello.class);
        proxyFactoryBean.setInterceptorNames("logInterceptor");
        proxyFactoryBean.setTargetName("helloTarget");
        return proxyFactoryBean;
    }

}
