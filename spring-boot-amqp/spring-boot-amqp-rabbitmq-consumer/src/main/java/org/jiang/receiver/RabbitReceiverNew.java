package org.jiang.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")
@Slf4j
public class RabbitReceiverNew {
    @RabbitHandler
    public void process(Map testMessage) {
        log.info("第二个消费者收到的消息:" + testMessage.toString());
    }
}
