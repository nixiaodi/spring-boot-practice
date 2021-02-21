package org.jiang.application;

import lombok.extern.slf4j.Slf4j;
import org.jiang.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class TemplateApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
        RabbitTemplate template = context.getBean(RabbitTemplate.class);

        //MessageProperties messageProperties = new MessageProperties();
        //messageProperties.getHeaders().put("desc","消息发送");
        //messageProperties.getHeaders().put("type",10);
        //
        //Message message = new Message("hello".getBytes(), messageProperties);
        //
        //template.send("","jiang.debug",message,new CorrelationData("spring.amqp"));
        //
        //context.close();

        template.convertAndSend("","jiang.debug","message before",message -> {
            MessageProperties properties = new MessageProperties();
            properties.getHeaders().put("desc","消息发送");
            properties.getHeaders().put("type",10);

            Message messageAfter = new Message("message after".getBytes(),properties);
            return messageAfter;
        });

        context.close();
    }
}
