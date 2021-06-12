package cn.jast.spring.lifecycle.config;

import cn.jast.spring.lifecycle.component.ABean;
import cn.jast.spring.lifecycle.component.FullBean;
import cn.jast.spring.lifecycle.component.MyBeanFactoryBean;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

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

    @Bean
    public MyBeanFactoryBean myBeanFactoryBean(){
        return new MyBeanFactoryBean();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("hello.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer(){
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocalOverride(true);
        propertyOverrideConfigurer.setLocation(new ClassPathResource("beanProp.properties"));
        return propertyOverrideConfigurer;
    }
}
