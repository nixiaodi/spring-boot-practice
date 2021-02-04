package org.jiang;

import lombok.extern.slf4j.Slf4j;
import org.jiang.lettuce.LettuceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/4
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class FactoryTest {
    @Autowired
    private LettuceConnectionFactory redisConnectFactory;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Test
    public void test01() {
        RedisConnection connection = redisConnectFactory.getConnection();
        connection.set("test".getBytes(),"hello".getBytes());
    }

    @Test
    public void test02() {
        int database = jedisConnectionFactory.getDatabase();
        log.info(String.valueOf(database));
        RedisConnection connection = jedisConnectionFactory.getConnection();
        String value = new String(Objects.requireNonNull(connection.get("test".getBytes())));
        log.info(value);
    }
}
