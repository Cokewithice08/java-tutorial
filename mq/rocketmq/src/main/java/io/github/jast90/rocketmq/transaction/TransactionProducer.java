package io.github.jast90.rocketmq.transaction;

import io.github.jast90.rocketmq.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * <a href="https://github.com/apache/rocketmq/blob/master/docs/cn/design.md#5-%E4%BA%8B%E5%8A%A1%E6%B6%88%E6%81%AF">事务消息</a>
 *
 * Created by jast90 on 2021/5/22
 */
public class TransactionProducer {
    private final static Logger logger = LoggerFactory.getLogger(TransactionProducer.class);

    public static void main(String[] args) throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("transaction-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);

        //消费者：只会消费TagA、TagC的消息；TagB的消息将会被回滚，消费者不可见
        producer.setTransactionListener(new TransactionListener() {
            //执行本地事务
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if (StringUtils.equalsIgnoreCase("TagA",msg.getTags())) {
                    //TagA的消息，提交事务，它允许消费者消费此消息。
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else if(StringUtils.equalsIgnoreCase("TagB",msg.getTags())){
                    //TagB的消息，回滚事务，它代表该消息将被删除，不允许被消费。
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else if(StringUtils.equalsIgnoreCase("TagC",msg.getTags())){
                    //TagC的消息，中间状态，它代表需要检查消息队列来确定状态。
                    return LocalTransactionState.UNKNOW;
                }
                //其他消息，中间状态，它代表需要检查消息队列来确定状态
                return LocalTransactionState.UNKNOW;
            }

            //MQ进行消息事务状态回查,默认回查15次
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                logger.info("消息事务状态回查,消息tag:{}",msg.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        String[] tags = new String[]{"TagA","TagB","TagC"};
        //发送3条 半消息
        for (int i = 0; i < 3; i++) {
            String body = "Hello"+i;
            Message message = new Message("transactionTopic",tags[i%tags.length],"key"+i,
                    body.getBytes(StandardCharsets.UTF_8));
            TransactionSendResult transactionSendResult = producer.sendMessageInTransaction(message, null);
            logger.debug("send message body:{},send status:{}",body,transactionSendResult.getSendStatus());

        }

//        producer.shutdown();
    }
}
/**
 * 18:56:22.360 [main] DEBUG io.github.jast90.rocketmq.transaction.TransactionProducer - send message body:Hello0,send status:SEND_OK
 * 18:56:22.673 [main] DEBUG io.github.jast90.rocketmq.transaction.TransactionProducer - send message body:Hello1,send status:SEND_OK
 * 18:56:22.971 [main] DEBUG io.github.jast90.rocketmq.transaction.TransactionProducer - send message body:Hello2,send status:SEND_OK
 * 18:57:23.569 [pool-2-thread-1] INFO  io.github.jast90.rocketmq.transaction.TransactionProducer - 消息事务状态回查,消息tag:TagC
 */
