package io.github.jast90.spring.lifecycle.config;

import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/11/29 17:33
 */
public class OverConfig {

    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer(){
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        propertyOverrideConfigurer.setLocalOverride(true);
        propertyOverrideConfigurer.setLocation(new ClassPathResource("beanProp.properties"));
        return propertyOverrideConfigurer;
    }
}
