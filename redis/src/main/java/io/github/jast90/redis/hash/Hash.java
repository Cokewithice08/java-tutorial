package io.github.jast90.redis.hash;

import redis.clients.jedis.Jedis;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2022/1/8 14:24
 */
public class Hash {

    private static Jedis jedis = new Jedis("192.168.56.102", 6379);

    public static void main(String[] args) {
        jedis.hset("breedRef:id:" + 1, "contract:id:" + 1, "2");
        System.out.println(jedis.hexists("breedRef:id:" + 1, "contract:id:" + 1));
    }

}
