package io.github.jast90.mybatis.cache;

import org.apache.ibatis.annotations.Param;

public interface Blog2CacheMapper {

    Blog selectBlog(int id);

    int update(@Param("id") int id, @Param("title") String title);

    int updateByEntity(Blog blog);
}
