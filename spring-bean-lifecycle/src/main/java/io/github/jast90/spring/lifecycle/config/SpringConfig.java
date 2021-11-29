package io.github.jast90.spring.lifecycle.config;

import io.github.jast90.spring.lifecycle.component.ABean;
import io.github.jast90.spring.lifecycle.component.FullBean;
import io.github.jast90.spring.lifecycle.component.MyBeanFactoryBean;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resources;

@Configuration
@Import(OverConfig.class)
@ComponentScan(basePackages = "io.github.jast90")
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

}
