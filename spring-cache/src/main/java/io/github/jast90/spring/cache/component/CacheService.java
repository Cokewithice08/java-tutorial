package io.github.jast90.spring.cache.component;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jast90 on 2021/6/1
 */
@Component
public class CacheService {

    @Cacheable(value = "cache",key = "'keys:'.concat(#id)",cacheManager = "cacheManager")
    public List<String> helloCache(int id){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        return list;
    }
}
