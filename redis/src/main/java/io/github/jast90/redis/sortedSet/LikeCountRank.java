package io.github.jast90.redis.sortedSet;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;

import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * 按点赞排名 回答会分页
 *
 * https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
 *
 * Created by jast90 on 2021/5/6
 */
public class LikeCountRank {

    private static Jedis jedis = new Jedis();

    static final String answerLikeRank = String.format("answer:like:rank");
    static int[] answerIds = {1,2,3,4};
    static List<Integer> uids = Lists.newArrayList(1,2,3,4,5,6,8);

    /**
     * 用户：2 赞了回答：1
     * 用户：3 赞了回答：1
     * 用户：4 赞了回答：1
     * 用户：5 赞了回答：1
     * 用户：6 赞了回答：1
     * 用户：6 赞了回答：2
     * 用户：3 赞了回答：3
     * 用户：4 赞了回答：3
     * 用户：5 赞了回答：3
     * 用户：4 赞了回答：4
     * 用户：5 赞了回答：4
     * 用户：6 赞了回答：4
     * 回答排名：
     * [[1,5.0], [4,3.0], [3,3.0], [2,1.0]]
     * 用户: 3 喜欢问题: 1
     *
     * @param args
     */
    public static void main(String[] args) {
        remove();
        likes();
        rank();
        if (isUserLikeAnswer(1,3)) {
            System.out.println(String.format("用户: %s 喜欢问题: %s",3,1));
        }
    }

    public static void likes(){
        int start = 0,end = 0;
        Random random = new Random();
        for (int questionId : answerIds) {
            start = random.nextInt(uids.size());
            end = random.nextInt(uids.size());
            while (end <= start){
//                System.out.println("重新获取起始位置");
                end = random.nextInt(uids.size());
                start = random.nextInt(uids.size());
            }
            userLikeAnswer(questionId,uids.subList(start,end));
        }
    }

    private static void remove(){
        jedis.del(answerLikeRank);
        String answerUserLikeKey;
        List<String> keys = Lists.newArrayList();
        for (int answerId : answerIds) {
            answerUserLikeKey = String.format("answer:user:like:%s",answerId);
            keys.add(answerUserLikeKey);
        }
        jedis.del(keys.toArray(new String[]{}));
    }

    private static void userLikeAnswer(int answerId , Collection<Integer> uids){
        String answerUserLikeKey = String.format("answer:user:like:%s",answerId);
        for (int uid : uids) {
            jedis.zincrby(answerLikeRank,1,String.valueOf(answerId));
            jedis.sadd(answerUserLikeKey,String.valueOf(uid));
            System.out.println(String.format("用户：%s 赞了回答：%s",uid,answerId));
        }
    }

    private static boolean isUserLikeAnswer(int answerId , int uid){
        String answerUserLikeKey = String.format("answer:user:like:%s",answerId);
        return jedis.sismember(answerUserLikeKey, String.valueOf(uid));
    }

    private static void rank(){
        System.out.println("回答排名：");
        System.out.println(jedis.zrevrangeWithScores(answerLikeRank, 0,-1));
    }
}

