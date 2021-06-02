package io.github.jast90.spring.cache;

import io.github.jast90.spring.cache.component.CacheService;
import io.github.jast90.spring.cache.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jast90 on 2021/6/1
 */
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CacheService cacheService = context.getBean(CacheService.class);
        System.out.println(cacheService.helloCache(3));
        System.out.println(cacheService.helloCache(3));
    }
}
