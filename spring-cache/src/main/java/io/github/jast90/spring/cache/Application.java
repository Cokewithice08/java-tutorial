package io.github.jast90.spring.cache;

import io.github.jast90.spring.cache.component.CacheService;
import io.github.jast90.spring.cache.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by jast90 on 2021/6/1
 */
public class Application {

    public static void main(String[] args) {
//        cache();
        redisList();
    }

    public static void cache(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CacheService cacheService = context.getBean(CacheService.class);
        System.out.println(cacheService.helloCache(3));
        System.out.println(cacheService.helloCache(3));
    }

    public static void redisList(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        BoundListOperations<String,String> boundListOperations = redisTemplate.boundListOps("user:queue");
        for (int i = 9999; i < 1000000; i++) {
            boundListOperations.rightPush(String.valueOf(i));
        }
    }
}
