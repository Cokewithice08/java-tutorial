package io.github.jast90.rocketmq.batch;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jast90 on 2021/5/22
 */
public class BatchProducer {
    private final static Logger logger = LoggerFactory.getLogger(BatchProducer.class);
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("batch-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.start();
        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            messages.add(new Message(topic,("Hello world " + i).getBytes(StandardCharsets.UTF_8)));
        }

        ListSplitter splitter = new ListSplitter(messages);
        while (splitter.hasNext()){
            List<Message> listItem = splitter.next();
            producer.send(listItem);
            logger.info("send batch messages:{},message count:{}",listItem,listItem.size());
        }
        producer.shutdown();
    }
}
