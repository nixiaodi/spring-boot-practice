package org.jiang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("org.jiang.mapper")
@Configuration
public class BaseConfig {
}
