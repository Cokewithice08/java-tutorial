package io.github.jast90.rocketmq.filter;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <a href="https://github.com/apache/rocketmq/blob/master/docs/cn/RocketMQ_Example.md#5-%E8%BF%87%E6%BB%A4%E6%B6%88%E6%81%AF%E6%A0%B7%E4%BE%8B">过滤消息</a>
 * Created by jast90 on 2021/5/22
 */
public class FilterProducer {

    private static final Logger logger = LoggerFactory.getLogger(FilterProducer.class);

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("filter-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.start();
        for (int i = 0; i < 10; i++) {
            String body = "Hello RocketMQ" + i;
            Message msg = new Message("FilterTopic",
                    body.getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 设置一些属性
            msg.putUserProperty("a", String.valueOf(i));
            SendResult sendResult = producer.send(msg);
            logger.debug("send message:{},send result:{}",msg,sendResult);
        }
        producer.shutdown();
    }
}
