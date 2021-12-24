package io.github.jast90.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class BaseTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSessionFactory sqlSessionFactory1 = null;

    protected SqlSession getSession(String config){
        SqlSession sqlSession = null;
        try {
            if(sqlSessionFactory == null){
                InputStream inputStream = Resources.getResourceAsStream(config);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
            sqlSession = sqlSessionFactory.openSession();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSession;
    }

    protected SqlSession getSession(){
        return getSession("mybatis-config.xml");
    }

    protected SqlSession getStatementSession(){
        SqlSession sqlSession = null;
        try {
            if(sqlSessionFactory1 == null){
                InputStream inputStream = Resources.getResourceAsStream("mybatis-config-statement.xml");
                sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream);
            }
            sqlSession = sqlSessionFactory1.openSession();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSession;
    }

}
