package io.github.jast90.mybatis.cache;

public interface BlogMapper {

    Blog selectBlog(int id);

    int update(int id,String title);
}
