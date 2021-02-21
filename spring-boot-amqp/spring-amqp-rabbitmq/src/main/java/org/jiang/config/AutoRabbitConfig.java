package org.jiang.config;

import org.jiang.constant.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class AutoRabbitConfig {
    //声明direct类型的Exchange
    @Bean
    public Exchange directExchange(){
        return new DirectExchange(RabbitConstant.DIRECT_EXCHANGE,true,false);
    }

    //声明topic类型的Exchange
    @Bean
    public Exchange topicExchange(){
        return new TopicExchange(RabbitConstant.TOPIC_EXCHANGE,true,false);
    }

    //声明fanout类型的Exchange
    @Bean
    public Exchange fanoutExchange(){
        return new FanoutExchange(RabbitConstant.FANOUT_EXCHANGE,true,false);
    }

    //声明headers类型的Exchange
    @Bean
    public Exchange headersExchange(){
        return new HeadersExchange("jiang.header.exchange",true,false);
    }

    @Bean
    public Queue debugQueue(){
        return new Queue(RabbitConstant.DEBUG_QUEUE,true);
    }

    @Bean
    public Queue infoQueue(){
        return new Queue(RabbitConstant.INFO_QUEUE,true);
    }

    @Bean
    public Queue errorQueue(){
        return new Queue(RabbitConstant.ERROR_QUEUE,true);
    }

    @Bean
    public Binding binding(){
        return new Binding(RabbitConstant.DEBUG_QUEUE,Binding.DestinationType.QUEUE,
                RabbitConstant.DIRECT_EXCHANGE,"jiang.debug",new HashMap());
    }

    @Bean
    public Binding binding2(){
        return new Binding(RabbitConstant.INFO_QUEUE,Binding.DestinationType.QUEUE,
                RabbitConstant.DIRECT_EXCHANGE,"jiang.info",new HashMap());
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(errorQueue()).to(directExchange())
                .with("jiang.error").and(new HashMap<>());
    }
}
