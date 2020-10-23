package cn.jast.spring.cicular.dependencies.config;

import cn.jast.spring.cicular.dependencies.component.BeanA;
import cn.jast.spring.cicular.dependencies.component.BeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConstructorInjectContext {
    @Bean
    public BeanA beanA(BeanB beanB){
        return new BeanA(beanB);
    }

    @Bean
    public BeanB beanB(BeanA beanA){
        return new BeanB(beanA);
    }
}
