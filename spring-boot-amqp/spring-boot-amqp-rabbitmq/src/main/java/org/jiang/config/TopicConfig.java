package org.jiang.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    /**
     *  绑定键
     */
    public static final String MAN = "topic.man";
    public static final String WOMAN = "topic.woman";

    @Bean
    public Queue manQueue() {
        return new Queue(TopicConfig.MAN);
    }

    @Bean
    public Queue womanQueue() {
        return new Queue(TopicConfig.WOMAN);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将manQueue和topicExchange绑定,而且绑定的键值为topic.man
     * 这样只要是消息携带的路由键是topic.man,才会分发到该队列
     */
    @Bean
    public Binding bindingExchangeMan() {
        return BindingBuilder.bind(manQueue()).to(exchange()).with(MAN);
    }

    /**
     *  将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
     *  这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
     */
    @Bean
    public Binding bindingExchangeWoman() {
        return BindingBuilder.bind(womanQueue()).to(exchange()).with("topic.#");
    }

}
