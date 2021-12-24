package io.github.jast90.mybatis.param;

import com.google.common.collect.Lists;
import io.github.jast90.mybatis.BaseTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/20 15:07
 */
public class Params extends BaseTest {

    @Test
    public void save() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("hello");
        user.setPassword("123456");
        int save = mapper.save(user);
        System.out.println(user.getId());
        session.commit();
        Assert.assertTrue(save == 1);
    }

    @Test
    public void queryById() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        User hello = mapper.queryById(2L);
        Assert.assertNotNull(hello);
    }

    @Test
    public void queryByNameAndPassword() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        User hello = mapper.queryByNameAndPassword("hello", "123456", Lists.newArrayList(1L));
        Assert.assertNotNull(hello);
    }

    @Test
    public void queryByIds() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        List<User> users = mapper.queryByIds(Lists.newArrayList());
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void queryByIdsInAndIdsNotIn() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        List<User> users = mapper.queryByIdsInAndIdsNotIn(Lists.newArrayList(1L), Lists.newArrayList(2L));
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void multiParamsByMap() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        Map<String, String> param = new HashMap<>();
        param.put("name", "hello");
        param.put("password", "123456");
        User hello = mapper.queryByNameAndPasswordByMap(param);
        Assert.assertNotNull(hello);
    }

    @Test
    public void queryByNameAndPasswordByMapAndId() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        Map<String, String> param = new HashMap<>();
        param.put("name", "hello");
        param.put("password", "123456");
        User hello = mapper.queryByNameAndPasswordByMapAndId(param, 2L);
        Assert.assertNotNull(hello);
    }

    @Test
    public void test() {
        UserMapper mapper = getSession().getMapper(UserMapper.class);
        List<User> users = mapper.queryListByBreedIdAndIdsNotInAndNamesIn("zh_CN", Lists.newArrayList("hello"));
    }

}
