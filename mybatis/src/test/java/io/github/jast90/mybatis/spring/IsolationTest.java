package io.github.jast90.mybatis.spring;

import io.github.jast90.mybatis.cache.Blog;
import org.junit.Test;

public class IsolationTest extends BaseTest{

    BlogService service = annotationConfigApplicationContext.getBean(BlogService.class);

    @Test
    public void selectUpdate(){
        boolean result = service.selectUpdate(1,"标题11111");
        System.out.println(result);
    }

    @Test
    public void update(){
        System.out.println(service.update());
    }
}
