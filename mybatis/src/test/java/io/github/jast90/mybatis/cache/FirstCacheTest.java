package io.github.jast90.mybatis.cache;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Collection;

/**
 * 一级缓存
 * - 缓存范围是session时，相同的sqlSession中的同一个namespace下的查询会读写缓存
 * - 缓存范围是statement时，都不会读写缓存。
 *
 */
public class FirstCacheTest extends BaseTest{

    @Test
    public void firstSessionCache(){
        SqlSession session = getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(1);//查询数据库
        Blog blog1 = mapper.selectBlog(1);//读取缓存 DefaultSqlSession 中的 BaseExecutor 中的 localCache
        System.out.println(blog == blog1);//true
        session.close();
    }

    @Test
    public void firstSessionCache1(){
        SqlSession session = getSession();
        SqlSession session1 = getSession();
        Collection<Cache> caches = session1.getConfiguration().getCaches();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        BlogMapper mapper1 = session1.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(1);//查询数据库
        session.close();
        Blog blog1 = mapper1.selectBlog(1);//查询数据库
        System.out.println(blog == blog1);//false
        session1.close();
    }

    @Test
    public void firstStatementCache(){
        SqlSession session = getStatementSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(1);//查询数据库
        Blog blog1 = mapper.selectBlog(1);//查询数据库
        System.out.println(blog == blog1);//false
        session.close();
    }

    @Test
    public void firstStatementCache1(){
        SqlSession session = getStatementSession();
        SqlSession session1 = getStatementSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        BlogMapper mapper1 = session1.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(1);//查询数据库
        session.close();
        Blog blog1 = mapper1.selectBlog(1);//查询数据库
        System.out.println(blog == blog1);//false
        session1.close();
    }
}
