package io.github.jast90.rocketmq.order;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by jast90 on 2021/5/21
 */
public class OrderedConsumer {
    private final static Logger logger = LoggerFactory.getLogger(OrderedProducer.class);


    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order-consumer");
        consumer.setNamesrvAddr(Constants.rocketmqHost);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("order","*");
        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    logger.info("Receive New Messages: {}",new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        logger.info("Consumer started.");
    }
}
/**
 * 消费消息顺序
 *
 * 16:23:09.771 [ConsumeMessageThread_12] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=100, stepDesc='创建'}
 * 16:23:10.080 [ConsumeMessageThread_13] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=100, stepDesc='支付'}
 * 16:23:10.377 [ConsumeMessageThread_14] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=100, stepDesc='扣减积分'}
 * 16:23:10.695 [ConsumeMessageThread_15] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=100, stepDesc='通知'}
 * 16:23:10.935 [ConsumeMessageThread_16] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=100, stepDesc='完成'}
 * 16:23:11.207 [ConsumeMessageThread_17] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=101, stepDesc='创建'}
 * 16:23:11.422 [ConsumeMessageThread_18] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=101, stepDesc='支付'}
 * 16:23:11.734 [ConsumeMessageThread_19] INFO  io.github.jast90.rocketmq.order.OrderedProducer - Receive New Messages: OrderStep{orderId=102, stepDesc='创建'}
 *
 * 修改消费者组后，会重新消费已经发送的消息
 */

