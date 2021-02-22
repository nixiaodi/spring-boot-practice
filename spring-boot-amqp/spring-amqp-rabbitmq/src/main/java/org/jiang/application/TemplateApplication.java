package org.jiang.application;

import lombok.extern.slf4j.Slf4j;
import org.jiang.config.RabbitConfig;
import org.jiang.constant.RabbitConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;


@Slf4j
public class TemplateApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
        RabbitTemplate template = context.getBean(RabbitTemplate.class);

        //SimpleMessageListenerContainer container = context.getBean(SimpleMessageListenerContainer.class);
        //container.addQueueNames(RabbitConstant.ERROR_QUEUE);
        //container.removeQueueNames(RabbitConstant.INFO_QUEUE);
        //System.out.println(container);
        //MessageProperties messageProperties = new MessageProperties();
        //messageProperties.getHeaders().put("desc","消息发送");
        //messageProperties.getHeaders().put("type",10);
        //
        //Message message = new Message("hello".getBytes(), messageProperties);
        //
        //template.send("","jiang.debug",message,new CorrelationData("spring.amqp"));
        //
        //context.close();

        template.convertAndSend(RabbitConstant.DIRECT_EXCHANGE,"jiang.debug","message before",message -> {
            MessageProperties properties = new MessageProperties();
            properties.getHeaders().put("desc","消息发送");
            properties.getHeaders().put("type",10);

            Message messageAfter = new Message("message after".getBytes(),properties);
            return messageAfter;
        });
        //
        //try {
        //    TimeUnit.SECONDS.sleep(5);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //
        //template.convertAndSend("","jiang.info","message before",message -> {
        //    MessageProperties properties = new MessageProperties();
        //    properties.getHeaders().put("desc","消息发送");
        //    properties.getHeaders().put("type",10);
        //
        //    Message messageAfter = new Message("message info".getBytes(),properties);
        //    return messageAfter;
        //});

        context.close();
    }
}
