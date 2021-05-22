package io.github.jast90.rocketmq.schedule;

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
public class ScheduleConsumer {

    private final static Logger logger = LoggerFactory.getLogger(ScheduleConsumer.class);

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("schedule-consumer");
        consumer.setNamesrvAddr(Constants.rocketmqHost);
        consumer.subscribe("scheduleTopic","*");
        //并发消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    logger.info("Receive New Messages,msgId:{} ,{} ms later",msg.getMsgId(),System.currentTimeMillis()-msg.getStoreTimestamp());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        logger.info("Schedule Consumer Started.");
    }
}
