package org.jiang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/4
 * @Version 1.0
 */
@Configuration
public class LettuceConfig {

    //@Bean
    public LettuceConnectionFactory redisConnectFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("123.57.66.144", 6379);
        configuration.setPassword("nidi1995230");
        return new LettuceConnectionFactory(configuration);
    }

    //@Bean
    @Primary
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("123.57.66.144", 6379);
        configuration.setPassword("nidi1995230");
        return new JedisConnectionFactory(configuration);
    }

    //@Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("123.57.66.144", 6379);
        configuration.setPassword("nidi1995230");
        return configuration;
    }
}
