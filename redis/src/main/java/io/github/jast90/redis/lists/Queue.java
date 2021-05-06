package io.github.jast90.redis.lists;


import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.List;

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
