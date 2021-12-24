package io.github.jast90.mybatis.param;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/20 14:58
 */
public interface UserMapper {

    User queryByNameAndPassword(String name, String password, List<Long> ids);

    User queryById(Long id);

    List<User> queryByIds(List<Long> ids);

    List<User> queryByIdsInAndIdsNotIn(List<Long> ids, List<Long> notInIds);

    User queryByNameAndPasswordByMap(Map<String, String> param);

    User queryByNameAndPasswordByMapAndId(Map<String, String> param, Long id);

    int save(User user);

    List<User> queryListByBreedIdAndIdsNotInAndNamesIn(@Param("locale") String local,
                                                       @Param("names") List<String> names);
}
