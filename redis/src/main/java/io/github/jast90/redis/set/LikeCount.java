package io.github.jast90.redis.set;

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
        if(isUserLikeAnswer(answerLikeCount,1)){
            System.out.println(String.format("用户：%s 已经点赞了回答：%s",1,questionId));
        }
        System.out.println(String.format("回答：%s 的点赞数：%s",questionId, jedis.scard(answerLikeCount)));
        if (!isUserLikeAnswer(answerLikeCount,99999)) {
            System.out.println(String.format("用户：%s 未点赞回答：%s",99999,questionId));
        }
    }

    private static void userLikeAnswer(String questionLikeCount,int uid, int questionId){
        jedis.sadd(questionLikeCount,String.valueOf(uid));
        System.out.println(String.format("用户：%s 赞了回答：%s",uid,questionId));
    }

    private static boolean isUserLikeAnswer(String questionLikeCount,int uid){
        return jedis.sismember(questionLikeCount, String.valueOf(uid));
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
 * 用户：1 已经点赞了回答：1
 * 回答：1 的点赞数：10
 * 用户：99999 未点赞回答：1
 */
