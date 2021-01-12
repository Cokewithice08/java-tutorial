package io.github.jast90.consistent.hash;

/**
 * 散列函数接口
 *
 * Created by jast90 on 2021/1/12
 */
public interface HashFunction<K> {
    K hash(Object object);
}
