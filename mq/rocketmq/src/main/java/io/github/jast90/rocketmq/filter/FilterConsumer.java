package io.github.jast90.rocketmq.filter;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jast90 on 2021/5/22
 */
public class FilterConsumer {

    private static final Logger logger = LoggerFactory.getLogger(FilterConsumer.class);

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("filter-consumer");
        consumer.setNamesrvAddr(Constants.rocketmqHost);
        // 只有订阅的消息有这个属性a, a >=0 and a <= 3
        consumer.subscribe("FilterTopic", MessageSelector.bySql("a between 0 and 3"));
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    logger.debug("收到消息：{},a:{}",new String(msg.getBody()),msg.getUserProperty("a"));
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
