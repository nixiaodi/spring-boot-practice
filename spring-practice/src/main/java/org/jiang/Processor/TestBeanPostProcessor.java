package org.jiang.Processor;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/3/11
 * @Version 1.0
 */

@Slf4j
public class TestBeanPostProcessor implements BeanPostProcessor {
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
