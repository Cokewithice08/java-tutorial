package io.github.jast90.rocketmq.broadcasting;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jast90 on 2021/5/22
 */
public class BroadcastConsumer {

    private final static Logger logger = LoggerFactory.getLogger(BroadcastConsumer.class);

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcast-consumer");
        consumer.setNamesrvAddr(Constants.rocketmqHost);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //设置消息模型
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.subscribe("BTopic","TagA");
        //并发消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                logger.info("{} -> Receive New Messages:{}","consumer",msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        logger.info("Broadcast Consumer Started.");

        DefaultMQPushConsumer consumer1 = new DefaultMQPushConsumer("broadcast-consumer1");
        consumer1.setNamesrvAddr(Constants.rocketmqHost);
        consumer1.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer1.setMessageModel(MessageModel.BROADCASTING);
        consumer1.subscribe("BTopic","TagA");
        consumer1.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                logger.info("{} -> Receive New Messages:{}","consumer1",msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer1.start();
        logger.info("Broadcast consumer1 Started.");
    }
}
