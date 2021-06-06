package io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator;

import io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator.component.LogInterceptor;
import io.github.jast90.spring.aop.api.DefaultAdvisorAutoProxyCreator.component.MyAdvisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jast90 on 2021/6/3
 */
@Configuration
@ComponentScan("cn.jast.spring.aop.api.DefaultAdvisorAutoProxyCreator")
public class AppConfig {

    @Bean
    public DefaultAdvisorAutoProxyCreator apc(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public MyAdvisor myAdvisor(){
        MyAdvisor myAdvisor = new MyAdvisor();
        myAdvisor.setAdvice(logInterceptor());
        return myAdvisor;
    }

    @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }
}
