package io.github.jast90.consistent.hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Java 通过SortedMap实现的 一致性hash算法
 * Created by jast90 on 2021/1/12
 */
public class ConsistentHash<K, N> {
    private final HashFunction<K> hashFunction;
    private final int numberOfReplicates;
    private final SortedMap<K, N> circle = new TreeMap<>();

    public ConsistentHash(HashFunction hashFunction, int numberOfReplicates, Collection<N> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicates = numberOfReplicates;
        for (N node : nodes) {

        }
    }

    /**
     * 添加物理节点
     *
     * @param node
     */
    public void add(N node) {
        for (int i = 0; i < numberOfReplicates; i++) {
            circle.put(hashFunction.hash(node.toString() + i), node);
        }
    }

    /**
     * 删除物理节点
     *
     * @param node
     */
    public void remove(N node) {
        for (int i = 0; i < numberOfReplicates; i++) {
            circle.remove(hashFunction.hash(node.toString() + i));
        }
    }

    /**
     * 返回key 所归属处理的节点
     *
     * @param key
     * @return
     */
    public N get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        K hash = hashFunction.hash(key);
        /**
         * 重点：
         * 1. 如果key在节点上，直接返回节点；不在节点上，执行2，3
         * 2. 找到比hash值更大的节点
         * 3. 如果找不到更大的取环的第一个元素，找的到取值更大节点的第一个元素
         */
        if (!circle.containsKey(hash)) {
            SortedMap<K, N> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
}
