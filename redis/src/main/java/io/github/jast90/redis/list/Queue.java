package io.github.jast90.redis.list;


import redis.clients.jedis.Jedis;

/**
 * Created by jast90 on 2021/4/27
 */
public class Queue {

    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(jedis.rpush("queue", String.valueOf(i)));
        }
        jedis.lpop("queue");
    }
}
