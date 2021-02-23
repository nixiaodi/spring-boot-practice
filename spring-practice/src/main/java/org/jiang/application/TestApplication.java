package org.jiang.application;

import lombok.extern.slf4j.Slf4j;
import org.jiang.config.GlobalConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/23
 * @Version 1.0
 */
@Slf4j
public class TestApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GlobalConfig.class);
        String[] definitionNames = context.getBeanDefinitionNames();
        log.info(Arrays.toString(definitionNames));
    }
}
