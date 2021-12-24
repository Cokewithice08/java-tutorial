package io.github.jast90.mybatis.cache;

import io.github.jast90.mybatis.BaseTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 二级缓存，不同的sqlSession中同一个namesapce下的相同查询语句是会读写缓存的。
 */
public class SecondCacheTest extends BaseTest {

    @Test
    public void secondCache(){
        SqlSession session = getSession();
        Blog2CacheMapper mapper = session.getMapper(Blog2CacheMapper.class);
        Blog blog = mapper.selectBlog(1);
        session.close();
        System.out.println(blog);

        SqlSession session0 = getSession();
        Blog2CacheMapper mapper0 = session0.getMapper(Blog2CacheMapper.class);
        mapper0.update(1,"");//
        session0.commit();//会清空缓存
        session0.close();

        SqlSession session1 = getSession();
        Blog2CacheMapper mapper1 = session1.getMapper(Blog2CacheMapper.class);
        Blog blog1 = mapper1.selectBlog(1);//查询缓存，Cache Hit Ratio [io.github.jast90.mybatis.cache.Blog2CacheMapper]: 0.5
        session1.close();
        System.out.println(blog1);

        System.out.println(blog == blog1);//false，混存返回的的clone的对象
    }

}
