package org.jiang.Processor;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/3/11
 * @Version 1.0
 */

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(TestBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}后置处理开始",beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}后置处理结束",beanName);
        return bean;
    }
}
