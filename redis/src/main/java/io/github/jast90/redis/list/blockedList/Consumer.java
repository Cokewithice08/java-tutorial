package io.github.jast90.redis.list.blockedList;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by jast90 on 2021/5/6
 */
public class Consumer {
    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {
        while (true){
            List<String> nodes = jedis.blpop(0,"nodes");
            System.out.println(nodes);
        }
    }
}
