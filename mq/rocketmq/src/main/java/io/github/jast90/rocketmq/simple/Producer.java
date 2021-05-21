package io.github.jast90.rocketmq.simple;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by jast90 on 2021/5/19
 */
public class Producer {

    private final static Logger logger = LoggerFactory.getLogger(Producer.class);

    public static void main(String[] args) throws Exception {
//        syncProducer();
        asyncProducer();
//        onewayProducer();
    }

    public static void syncProducer() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("sync-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.setSendMsgTimeout(400000);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message();
            msg.setTopic("TopicTest");
            msg.setTags("TagA");
            msg.setBody(("Hello RocketMQ "+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            logger.info("{}",sendResult);
        }
        producer.shutdown();
    }

    public static void asyncProducer() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("async-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        int messageCount = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < messageCount; i++) {
            final int index = i;
            Message msg = new Message("Jodie_topic_1023",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch.countDown();
                    logger.info("{} OK {}",index,sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    countDownLatch.countDown();
                    logger.info("{} Exception {}", index, e);
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await(5, TimeUnit.SECONDS);
        producer.shutdown();
    }

    public static void onewayProducer() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("oneway-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicTest" ,
                    "TagA",
                    ("Hello RocketMQ " +i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            producer.sendOneway(msg);
        }
        Thread.sleep(5000);
        producer.shutdown();
    }
}
