package org.jiang.application;

import lombok.extern.slf4j.Slf4j;
import org.jiang.config.RabbitConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/20
 * @Version 1.0
 */
@ComponentScan
@Slf4j
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);

        // 创建三种类型的Exchange
        //admin.declareExchange(new DirectExchange("jiang.direct.exchange",true,false));
        //admin.declareExchange(new TopicExchange("jiang.topic.exchange",true,false));
        //admin.declareExchange(new FanoutExchange("jiang.fanout.exchange",true,false));
        //boolean flag = admin.deleteExchange("jiang.fanout.exchange");
        //log.info(String.valueOf(flag));

        // 声明队列
        //admin.declareQueue(new Queue("jiang.debug",true));
        //admin.declareQueue(new Queue("jiang.info",true));
        //admin.declareQueue(new Queue("jiang.error",true));

        // 声明绑定
        //admin.declareBinding(new Binding("jiang.debug", Binding.DestinationType.QUEUE,
        //        "jiang.direct.exchange","jiang.test",new HashMap<>()));

        // 解绑
        admin.removeBinding(BindingBuilder.bind(new Queue("jiang.debug")).to(new DirectExchange("jiang.direct.exchange")).with("jiang.test"));

    }
}
