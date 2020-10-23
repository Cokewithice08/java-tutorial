package cn.jast.spring.cicular.dependencies.config;

import cn.jast.spring.cicular.dependencies.component.Bean1;
import cn.jast.spring.cicular.dependencies.component.Bean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircularDependenciesBySetterInjectContext {

    @Bean
    public Bean1 bean1(){
        Bean1 bean1 = new Bean1();
        return bean1;
    }

    @Bean
    public Bean2 bean2(){
        Bean2 bean2 = new Bean2();
        return bean2;
    }
}
