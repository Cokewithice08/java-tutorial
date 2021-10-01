package io.github.jast90.mybatis.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BaseTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MybatisConfig.class);
}
