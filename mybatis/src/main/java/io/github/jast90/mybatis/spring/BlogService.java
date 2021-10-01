package io.github.jast90.mybatis.spring;

import io.github.jast90.mybatis.cache.Blog;
import io.github.jast90.mybatis.cache.Blog2CacheMapper;
import io.github.jast90.mybatis.cache.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {
    @Autowired
    private Blog2CacheMapper blogMapper;


    @Transactional
    public Blog select(int id) {
        return blogMapper.selectBlog(id);
    }

    @Transactional
    public boolean selectUpdate(int id,String title) {
        Blog blog = blogMapper.selectBlog(id);
        blog.setTitle(title);
        int i = blogMapper.updateByEntity(blog);
        return i == 1;
    }

    @Transactional
    public boolean update(){
        int i = blogMapper.update(1,"更新了");
        return i==1;
    }

}
