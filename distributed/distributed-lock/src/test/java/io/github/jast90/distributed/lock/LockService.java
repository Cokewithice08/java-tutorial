package io.github.jast90.distributed.lock;


import io.github.jast90.distributed.lock.zk.ZKDistributedLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class LockService {

    private final Logger logger = LoggerFactory.getLogger(LockService.class);

    String lockName = "/goods/stock/lock/%s";

    public Map<Integer,Integer> goodsStock = new ConcurrentHashMap<>();

    public LockService(){
        goodsStock.put(100,3);
        goodsStock.put(101,3);
        goodsStock.put(102,3);
    }

    public boolean reduceStock(int goodsId){
        long start = System.currentTimeMillis();
        ZKDistributedLock lock = new ZKDistributedLock(String.format(lockName,goodsId));
        try {
            if (!lock.tryLock()) {
                logger.info("could not acquire the lock");
            }
            int stock = goodsStock.get(goodsId);
            //查库存
            if (stock > 0) {
                //减库存
                stock--;
                goodsStock.put(goodsId,stock);
                logger.info("stock:" + stock);
                return true;
            } else {
                logger.info("no stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            logger.info("cost time:" + (end - start));
        }
        return false;
    }
}
