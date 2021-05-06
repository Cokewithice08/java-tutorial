package io.github.jast90.redis.sortedSet;

import redis.clients.jedis.Jedis;

/**
 * Created by jast90 on 2021/5/6
 */
public class LikeCount {

    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {
        int questionId = 1;
        String answerLikeCount = String.format("like:count:answer:%s",questionId);
        String uid ;
        jedis.del(answerLikeCount);
        for (int i = 0; i < 10; i++) {
            userLikeAnswer(answerLikeCount,i,questionId);
        }
        if(jedis.zadd(answerLikeCount, 1, "1") == 0){
            System.out.println(String.format("用户：%s 已经点赞了回答：%s,不能继续点赞",1,questionId));
        }
        System.out.println(String.format("回答：%s 的点赞数：%s",questionId, jedis.zcard(answerLikeCount)));
        if (!isUserLikeAnswer(answerLikeCount,99999)) {
            System.out.println(String.format("用户：%s 未点赞回答",99999));
        }
    }

    private static void userLikeAnswer(String questionLikeCount,int uid, int questionId){
        jedis.zadd(questionLikeCount,1,String.valueOf(uid));
        System.out.println(String.format("用户：%s 赞了回答：%s",uid,questionId));
    }

    private static boolean isUserLikeAnswer(String questionLikeCount,int uid){
        Long rank = jedis.zrank(questionLikeCount, String.valueOf(uid));
        return rank != null;
    }
}

/**
 * 用户：0 赞了回答：1
 * 用户：1 赞了回答：1
 * 用户：2 赞了回答：1
 * 用户：3 赞了回答：1
 * 用户：4 赞了回答：1
 * 用户：5 赞了回答：1
 * 用户：6 赞了回答：1
 * 用户：7 赞了回答：1
 * 用户：8 赞了回答：1
 * 用户：9 赞了回答：1
 * 用户：1 已经点赞了回答：1,不能继续点赞
 * 回答：1 的点赞数：10
 * 用户：99999 未点赞回答
 */
