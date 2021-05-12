package io.github.jast90.redis.geo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.GeoRadiusParam;

import java.util.List;

/**
 *
 * Created by jast90 on 2021/5/7
 */
public class GEO {

    private static final Logger logger = LoggerFactory.getLogger(GEO.class);

    private static Jedis jedis = new Jedis();

    public static void main(String[] args) {
//        add();
//        pos();
//        dist();
        radiusByMember();
    }

    public static void add(){
        jedis.geoadd("house",117.976506,28.467041,"九州奥城");
        jedis.geoadd("house",117.988670,28.471533,"洋码头新零售总部");
    }


    public static void pos(){
        logger.debug("{}",jedis.geopos("house", "九州奥城"));
    }

    public static void dist(){
        Double geodist = jedis.geodist("house", "九州奥城", "洋码头新零售总部", GeoUnit.KM);
        logger.debug("九州奥城 与 洋码头新零售总部的距离 是：{} km",geodist);
    }

    public static void radiusByMember(){

        List<GeoRadiusResponse> geoRadiusResponses = jedis.georadiusByMember("house", "九州奥城", 1, GeoUnit.KM,
                GeoRadiusParam.geoRadiusParam().withCoord().withDist().sortDescending());
        for (GeoRadiusResponse geoRadiusRespons : geoRadiusResponses) {
            logger.info("成员：{}，距离：{}",geoRadiusRespons.getMemberByString(),geoRadiusRespons.getDistance());
        }
    }


}
