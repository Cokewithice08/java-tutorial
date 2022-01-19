package io.github.jast90.mybatis.middle;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2022/1/19 13:34
 */
public interface MiddleMapper {

    int query(@Param("key1") String key1, @Param("key2") String key2);

    int save(Middle middle);
}
