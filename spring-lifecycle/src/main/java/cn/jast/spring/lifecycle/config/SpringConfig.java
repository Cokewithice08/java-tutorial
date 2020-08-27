package cn.jast.spring.lifecycle.config;

import cn.jast.spring.lifecycle.component.FullBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cn.jast")
public class SpringConfig {

    @Bean(initMethod = "customInit",destroyMethod = "customDestroy")
    public FullBean fullBean(){
        return new FullBean();
    }
}
