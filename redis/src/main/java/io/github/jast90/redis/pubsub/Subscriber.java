package io.github.jast90.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by jast90 on 2021/5/6
 */
public class Subscriber {
    private static Jedis jedis = new Jedis();

    /**
     * 简单的发布订阅，扩展性不好
     * @param args
     */
    public static void main(String[] args) {
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println(String.format("收到消息:[%s] 主题：[%s]",message,channel));
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                super.onSubscribe(channel, subscribedChannels);
                System.out.println(String.format("订阅主题：%s",channel));
            }
        },"hello");
    }
}
