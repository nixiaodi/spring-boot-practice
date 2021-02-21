package org.jiang.config;

import lombok.extern.slf4j.Slf4j;
import org.jiang.constant.RabbitConstant;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/20
 * @Version 1.0
 */
@Configuration
@ComponentScan("org.jiang")
@Slf4j
public class RabbitConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost("123.57.66.144");
        factory.setPort(5672);
        factory.setUsername("jiang");
        factory.setPassword("nidi1995230");
        factory.setVirtualHost("Autotest");
        return factory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        //设置Exchange默认操作的exchange和routingKey
        template.setExchange(RabbitConstant.DIRECT_EXCHANGE);
        template.setRoutingKey("jiang.debug");
        return template;
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        //队列可以是多个，参数是String的数组
        container.setQueueNames(RabbitConstant.DEBUG_QUEUE);
        container.setMessageListener((ChannelAwareMessageListener)(message, channel) -> {
            log.info("======接收到的消息=====");
            log.info(message.getMessageProperties().toString());
            log.info(new String(message.getBody()));
        });
        return container;
    }
}
