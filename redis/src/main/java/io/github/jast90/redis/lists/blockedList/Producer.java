package io.github.jast90.redis.lists.blockedList;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created by jast90 on 2021/5/6
 */
public class Producer {

    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {
        jedis.rpush("nodes", UUID.randomUUID().toString());
    }
}
