package io.github.jast90.consistent.hash;


import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;

import java.util.*;

/**
 * Java 通过SortedMap实现的 一致性hash算法
 * Created by jast90 on 2021/1/12
 */
public class ConsistentHashing<N,O> {
    private final HashFunction hashFunction;
    private final int numberOfReplicates;
    private final SortedMap<Long, N> circle = new TreeMap<>();

    public ConsistentHashing(HashFunction hashFunction, int numberOfReplicates, Collection<N> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicates = numberOfReplicates;
        for (N node : nodes) {
            add(node);
        }
    }

    /**
     * 添加物理节点
     *
     * @param node
     */
    public void add(N node) {
        for (int i = 0; i < numberOfReplicates; i++) {
            circle.put(hashFunction.newHasher().putString(node.toString() + i, Charsets.UTF_8).hash().asLong(), node);
        }
    }

    /**
     * 删除物理节点
     *
     * @param node
     */
    public void remove(N node) {
        for (int i = 0; i < numberOfReplicates; i++) {
            circle.remove(hashFunction.newHasher().putString(node.toString() + i, Charsets.UTF_8).hash().asLong());
        }
    }

    /**
     * 返回key 所归属处理的节点
     *
     * @param key
     * @param funnel
     * @return
     */
    public N get(String key, Funnel<String> funnel) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hashFunction.newHasher().putObject(key,funnel).hash().asLong();
        /**
         * 重点：
         * 1. 如果key在节点上，直接返回节点；不在节点上，执行2，3
         * 2. 找到比hash值更大的节点
         * 3. 如果找不到更大的取环的第一个元素，找的到取值更大节点的第一个元素
         */
        if (!circle.containsKey(hash)) {
            SortedMap<Long, N> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    // 统计对象与节点的映射关系
    public void dumpObjectNodeMap(String label, int objectMin, int objectMax) {
        // 统计
        Map<N, Integer> objectNodeMap = new TreeMap<>(); // IP => COUNT
        for (int object = objectMin; object <= objectMax; ++object) {
            N nodeIp = get(Integer.toString(object), new Funnel<String>() {
                @Override
                public void funnel(String from, PrimitiveSink into) {
                    into.putString(from, Charsets.UTF_8);
                }
            });
            Integer count = objectNodeMap.get(nodeIp);
            objectNodeMap.put(nodeIp, (count == null ? 0 : count + 1));
        }

        // 打印
        double totalCount = objectMax - objectMin + 1;
        System.out.println("======== " + label + " ========");
        for (Map.Entry<N, Integer> entry : objectNodeMap.entrySet()) {
            long percent = (int) (100 * entry.getValue() / totalCount);
            System.out.println("IP=" + entry.getKey() + ": RATE=" + percent + "%");
        }
    }

    public static void main(String[] args) {
        int c_1 = 1;
        int c_32 = 32;
        int c_1M = 1024 * 1024;
        int c_16K = 16 * 1024;//redis的槽数16384

        test(c_1);
        test(c_32);
        test(c_16K);
        test(c_1M);
    }

    public static void test(int numberOfReplicates){
        System.out.println("numberOfReplicates="+numberOfReplicates);
        long start = System.currentTimeMillis();
        ConsistentHashing<String,String> ch = new ConsistentHashing<>(Hashing.sha256(),numberOfReplicates,
                Arrays.asList("192.168.1.100", "192.168.1.101", "192.168.1.102"));
        // 初始情况
        ch.dumpObjectNodeMap("初始情况", 0, 65536);

        // 删除物理节点
        ch.remove("192.168.1.100");
        ch.dumpObjectNodeMap("删除物理节点", 0, 65536);

        // 添加物理节点
        ch.add("192.168.1.108");
        ch.dumpObjectNodeMap("添加物理节点", 0, 65536);
        long end = System.currentTimeMillis();
        System.out.println(String.format("耗时：%s ms %s",end-start,"\r\n"));
    }
}

/**
 * numberOfReplicates=1
 * ======== 初始情况 ========
 * IP=192.168.1.100: RATE=24%
 * IP=192.168.1.101: RATE=58%
 * IP=192.168.1.102: RATE=16%
 * ======== 删除物理节点 ========
 * IP=192.168.1.101: RATE=58%
 * IP=192.168.1.102: RATE=41%
 * ======== 添加物理节点 ========
 * IP=192.168.1.101: RATE=58%
 * IP=192.168.1.102: RATE=37%
 * IP=192.168.1.108: RATE=3%
 * 耗时：496 ms
 *
 * numberOfReplicates=32
 * ======== 初始情况 ========
 * IP=192.168.1.100: RATE=37%
 * IP=192.168.1.101: RATE=33%
 * IP=192.168.1.102: RATE=28%
 * ======== 删除物理节点 ========
 * IP=192.168.1.101: RATE=51%
 * IP=192.168.1.102: RATE=48%
 * ======== 添加物理节点 ========
 * IP=192.168.1.101: RATE=36%
 * IP=192.168.1.102: RATE=36%
 * IP=192.168.1.108: RATE=26%
 * 耗时：253 ms
 *
 * numberOfReplicates=16384
 * ======== 初始情况 ========
 * IP=192.168.1.100: RATE=33%
 * IP=192.168.1.101: RATE=32%
 * IP=192.168.1.102: RATE=33%
 * ======== 删除物理节点 ========
 * IP=192.168.1.101: RATE=50%
 * IP=192.168.1.102: RATE=49%
 * ======== 添加物理节点 ========
 * IP=192.168.1.101: RATE=33%
 * IP=192.168.1.102: RATE=33%
 * IP=192.168.1.108: RATE=32%
 * 耗时：848 ms
 *
 * numberOfReplicates=1048576
 * ======== 初始情况 ========
 * IP=192.168.1.100: RATE=33%
 * IP=192.168.1.101: RATE=33%
 * IP=192.168.1.102: RATE=33%
 * ======== 删除物理节点 ========
 * IP=192.168.1.101: RATE=50%
 * IP=192.168.1.102: RATE=49%
 * ======== 添加物理节点 ========
 * IP=192.168.1.101: RATE=33%
 * IP=192.168.1.102: RATE=33%
 * IP=192.168.1.108: RATE=33%
 * 耗时：13356 ms
 */
