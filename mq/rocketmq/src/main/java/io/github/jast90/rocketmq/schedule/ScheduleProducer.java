package io.github.jast90.rocketmq.schedule;

import io.github.jast90.rocketmq.Constants;
import io.github.jast90.rocketmq.broadcasting.BroadcastProducer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jast90 on 2021/5/22
 */
public class ScheduleProducer {
    private final static Logger logger = LoggerFactory.getLogger(ScheduleProducer.class);

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("schedule-producer");
        producer.setNamesrvAddr(Constants.rocketmqHost);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("scheduleTopic","Hello World".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // This message will be delivered to consumer 10 seconds later.
            msg.setDelayTimeLevel(3);
            SendResult sendResult = producer.send(msg);
            logger.info("Send message ,result:{}",sendResult);
        }
        producer.shutdown();
    }
}
