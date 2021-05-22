package io.github.jast90.rocketmq.transaction;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jast90 on 2021/5/22
 */
public class TransactionConsumer {
    private static final Logger logger = LoggerFactory.getLogger(TransactionConsumer.class);

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("transaction-consumer");
        consumer.setNamesrvAddr(Constants.rocketmqHost);
        consumer.subscribe("transactionTopic","*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    logger.info("Receive New Messages,body: {},tags:{}", new String(msg.getBody()),msg.getTags());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        logger.info("Consumer Started.");
    }
}
/**
 * 18:55:03.256 [ConsumeMessageThread_1] INFO  io.github.jast90.rocketmq.transaction.TransactionConsumer - Receive New Messages,body: Hello0,tags:TagA
 * 18:55:23.877 [ConsumeMessageThread_2] INFO  io.github.jast90.rocketmq.transaction.TransactionConsumer - Receive New Messages,body: Hello2,tags:TagC
 */
