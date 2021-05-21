package io.github.jast90.rocketmq.order;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.MQAdmin;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * Created by jast90 on 2021/5/19
 */
public class OrderedProducer {
    private final static Logger logger = LoggerFactory.getLogger(OrderedProducer.class);

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("order-producer");

        producer.setNamesrvAddr(Constants.rocketmqHost);

        producer.start();

        //5种Tag，10个订单，8个队列
        String[] tags = new String[]{"TagA","TagB","TagC","TagD","TagE"};
        int i = 0;
        for (OrderStep orderStep : OrderStep.orderSteps()) {
            Message msg = new Message("order", tags[i % tags.length], "orderId:" + orderStep.getOrderId(),
                    orderStep.toString().getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg, (MessageQueueSelector) (mqs, msg1, arg) -> {
//                logger.info("arg:{},mqs:{}",arg,mqs);
                Long id = (Long) arg;
                int index = (int) (id % mqs.size());
                return mqs.get(index);
            }, orderStep.getOrderId());
            logger.info("send message: {},result: {}", orderStep,sendResult);
        }

        //server shutdown
        producer.shutdown();
    }


}
/**
 * 发送消息顺序
 *
 * 16:23:09.776 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=100, stepDesc='创建'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A834A830000, offsetMsgId=23F1700D00002A9F000000000004ABDB, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=4], queueOffset=5]
 * 16:23:10.079 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=100, stepDesc='支付'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A834CD00001, offsetMsgId=23F1700D00002A9F000000000004ACCA, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=4], queueOffset=6]
 * 16:23:10.376 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=100, stepDesc='扣减积分'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A834DFF0002, offsetMsgId=23F1700D00002A9F000000000004ADB9, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=4], queueOffset=7]
 * 16:23:10.692 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=100, stepDesc='通知'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A834F290003, offsetMsgId=23F1700D00002A9F000000000004AEAE, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=4], queueOffset=8]
 * 16:23:10.935 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=100, stepDesc='完成'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A8350650004, offsetMsgId=23F1700D00002A9F000000000004AF9D, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=4], queueOffset=9]
 * 16:23:11.206 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=101, stepDesc='创建'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A8351580005, offsetMsgId=23F1700D00002A9F000000000004B08C, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=5], queueOffset=2]
 * 16:23:11.420 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=101, stepDesc='支付'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A8352660006, offsetMsgId=23F1700D00002A9F000000000004B17B, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=5], queueOffset=3]
 * 16:23:11.734 [main] INFO  io.github.jast90.rocketmq.order.OrderedProducer - send message: OrderStep{orderId=102, stepDesc='创建'},result: SendResult [sendStatus=SEND_OK, msgId=C0A80065F61218B4AAC26A83533D0007, offsetMsgId=23F1700D00002A9F000000000004B26A, messageQueue=MessageQueue [topic=order, brokerName=broker-a, queueId=6], queueOffset=1]
 */
