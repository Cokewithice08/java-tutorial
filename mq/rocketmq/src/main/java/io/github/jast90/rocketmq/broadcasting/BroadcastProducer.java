package io.github.jast90.rocketmq.broadcasting;

import io.github.jast90.rocketmq.Constants;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * Created by jast90 on 2021/5/22
 */
public class BroadcastProducer {

    private final static Logger logger = LoggerFactory.getLogger(BroadcastProducer.class);

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("broadcast-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("BTopic","TagA","OrderID188","Hello World".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            logger.info("{}",sendResult);
        }
        producer.shutdown();
    }
}
