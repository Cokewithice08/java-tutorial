package io.github.jast90.redis.pubsub;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created by jast90 on 2021/5/6
 */
public class Publisher {

    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {
        String msg = UUID.randomUUID().toString();
        String topic = "hello";
        Long count = jedis.publish("hello", msg);
        System.out.println(String.format("发送消息:[%s] 到主题：[%s]，收到消息的客户端数量：%s",msg,topic,count));
    }
}
