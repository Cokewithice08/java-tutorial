package cn.jast.spring.lifecycle.config;

import cn.jast.spring.lifecycle.component.ABean;
import cn.jast.spring.lifecycle.component.FullBean;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cn.jast")
public class SpringConfig {

    @Bean(initMethod = "customInit",destroyMethod = "customDestroy")
    public FullBean fullBean(){
        FullBean fullBean = new FullBean();
        fullBean.setHello("Hello World");
//        fullBean.setaBean(aBean());
        return fullBean;
    }

    @Bean
    public ABean aBean(){
        ABean aBean = new ABean();
//        aBean.setFullBean(fullBean());
        return aBean;
    }
}
