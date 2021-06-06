package io.github.jast90.spring.aop.usage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "cn.jast.spring.aop.usage")
@EnableAspectJAutoProxy
public class AppConfig {

}
