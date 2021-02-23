package org.jiang.config;

import lombok.extern.slf4j.Slf4j;
import org.jiang.constant.RabbitConstant;
import org.jiang.handler.MessageHanler;
import org.jiang.handler.TestMessageConvert;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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
    private int count = 0;

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

    //@Bean
    //public SimpleMessageListenerContainer messageListenerContainer() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory());
    //    //队列可以是多个，参数是String的数组
    //    container.setQueueNames(RabbitConstant.DEBUG_QUEUE);
    //    container.setMessageListener((ChannelAwareMessageListener)(message, channel) -> {
    //        log.info("======接收到的消息=====");
    //        log.info(message.getMessageProperties().toString());
    //        log.info(new String(message.getBody()));
    //    });
    //    return container;
    //}

    //@Bean
    //public SimpleMessageListenerContainer messageListenerContainer() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory());
    //    container.setQueueNames(RabbitConstant.DEBUG_QUEUE,RabbitConstant.INFO_QUEUE);
    //    container.setMessageListener(message -> {
    //        log.info("===接收到" + message.getMessageProperties().getConsumerQueue() + "队列的消息");
    //        log.info(message.getMessageProperties().toString());
    //        log.info(new String(message.getBody()));
    //    });
    //    return container;
    //}

    //@Bean
    //public SimpleMessageListenerContainer messageListenerContainer() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory());
    //    container.setQueueNames(RabbitConstant.DEBUG_QUEUE,RabbitConstant.INFO_QUEUE);
    //    //后置处理器，接收到的消息都添加了Header请求头
    //    container.setAfterReceivePostProcessors(message -> {
    //        message.getMessageProperties().getHeaders().put("jiang","hello");
    //        return message;
    //    });
    //    container.setMessageListener(message -> {
    //        log.info("===接收到" + message.getMessageProperties().getConsumerQueue() + "队列的消息");
    //        log.info(message.getMessageProperties().toString());
    //        log.info(new String(message.getBody()));
    //    });
    //    return container;
    //}

    //@Bean
    //public SimpleMessageListenerContainer messageListenerContainer() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory());
    //    container.setQueueNames(RabbitConstant.DEBUG_QUEUE,RabbitConstant.INFO_QUEUE);
    //    //设置消费者的consumerTag_tag
    //    container.setConsumerTagStrategy(queue -> queue + "_" + (++count));
    //    //设置消费者的Arguments
    //    ConcurrentHashMap<String,Object> args = new ConcurrentHashMap();
    //    args.put("module","订单模块");
    //    args.put("fun","发送消息");
    //    container.setConsumerArguments(args);
    //    container.setMessageListener(message -> {
    //        log.info("===接收到" + message.getMessageProperties().getConsumerQueue() + "队列的消息");
    //        log.info(message.getMessageProperties().toString());
    //        log.info(new String(message.getBody()));
    //    });
    //    return container;
    //}

    //@Bean
    //public SimpleMessageListenerContainer messageListenerContainer() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory());
    //    container.setQueueNames(RabbitConstant.DEBUG_QUEUE,RabbitConstant.INFO_QUEUE);
    //    container.setConcurrentConsumers(5);
    //    container.setMaxConcurrentConsumers(10);
    //    container.setMessageListener(message -> {
    //        log.info("===接收到" + message.getMessageProperties().getConsumerQueue() + "队列的消息");
    //        log.info(message.getMessageProperties().toString());
    //        log.info(new String(message.getBody()));
    //    });
    //    return container;
    //}

    //@Bean
    //public SimpleMessageListenerContainer messageListenerContainer() {
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //    container.setConnectionFactory(connectionFactory());
    //
    //    MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageHanler());
    //    //设置处理器的消费消息的默认方法,如果没有设置，那么默认的处理器中的默认方式是handleMessage方法
    //    adapter.setDefaultListenerMethod("onMessage");
    //    HashMap<String, String> queueOrTagToMethodName = new HashMap<>();
    //    queueOrTagToMethodName.put("order","onOrder");
    //    queueOrTagToMethodName.put("pay","onPay");
    //    adapter.setQueueOrTagToMethodName(queueOrTagToMethodName);
    //    container.setMessageListener(adapter);
    //    return container;
    //}

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());

        MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageHanler());
        //设置处理器的消费消息的默认方法,如果没有设置，那么默认的处理器中的默认方式是handleMessage方法
        adapter.setDefaultListenerMethod("onMessage");
        adapter.setMessageConverter(new TestMessageConvert());
        container.setMessageListener(adapter);
        return container;
    }
}
