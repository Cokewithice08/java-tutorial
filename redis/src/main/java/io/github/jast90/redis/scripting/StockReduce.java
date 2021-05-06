package io.github.jast90.redis.scripting;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * 库存扣减
 *
 * Created by jast90 on 2021/5/6
 */
public class StockReduce {

    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {
        int goodId = 1;
        jedis.setnx(String.valueOf(goodId),String.valueOf(10));

        String script = "-- 库存key\n" +
                "local key = KEYS[1]\n" +
                "-- 扣减库存\n" +
                "local reduceBy = tonumber(ARGV[1])\n" +
                "-- 获取当前库存\n" +
                "local stock = tonumber(redis.call('get',key) or \"0\")\n" +
                "-- 库存不够直接返回\n" +
                "if stock < reduceBy then\n" +
                "    return 0;\n" +
                "else\n" +
                "    local remain = tonumber(redis.call(\"DECRBY\",key,reduceBy))\n" +
                "    return remain\n" +
                "end";
        long eval = (long) jedis.eval(script, Collections.singletonList(String.valueOf(goodId)), Collections.singletonList(String.valueOf(goodId)));
        System.out.println(eval);
    }
}
