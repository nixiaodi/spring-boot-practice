package org.jiang.config;

import org.jiang.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/23
 * @Version 1.0
 */
@Configuration
public class GlobalConfig {
    @Bean
    public Car car() {
        Car car =  new Car();
        car.setName("宝马");
        car.setPrice(120000L);
        return car;
    }
}
