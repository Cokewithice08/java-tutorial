package io.github.jast90.mybatis.spring;

import io.github.jast90.mybatis.cache.Blog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MybatisConfig.class);
        BlogService blogService = annotationConfigApplicationContext.getBean("blogService", BlogService.class);
        Blog blog1 = blogService.select(1);
        Blog blog2 = blogService.select(1);
        System.out.println(blogService.update());
        System.out.println(blog1==blog2);
    }
}
