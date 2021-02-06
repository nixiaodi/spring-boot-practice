package org.jiang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jiang.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
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
    //@Autowired
    //private LettuceConnectionFactory redisConnectFactory;
    //
    //@Autowired
    //private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //@Test
    //public void test01() {
    //    RedisConnection connection = redisConnectFactory.getConnection();
    //    connection.set("test".getBytes(),"hello".getBytes());
    //}
    //
    //@Test
    //public void test02() {
    //    int database = jedisConnectionFactory.getDatabase();
    //    log.info(String.valueOf(database));
    //    RedisConnection connection = jedisConnectionFactory.getConnection();
    //    String value = new String(Objects.requireNonNull(connection.get("test".getBytes())));
    //    log.info(value);
    //}

    @Test
    public void ObjectConvert() {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("宝马",18000L,"dark");
        try {
            String res = mapper.writeValueAsString(car);
            System.out.println(res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonConvert() {
        ObjectMapper mapper = new ObjectMapper();
        String resource = "{\"name\":\"宝马\",\"price\":18000,\"color\":\"dark\"}";
        try {
            Car car = mapper.readValue(resource, Car.class);
            String color = car.getColor();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonConvert2() {
        ObjectMapper mapper = new ObjectMapper();
        String resource = "{\"name\":\"宝马\",\"price\":18000,\"color\":\"dark\"}";
        try {
            Map<String, Object> map = mapper.readValue(resource, new TypeReference<Map<String, Object>>() {
            });
            System.out.println(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cluster() {
        String res = stringRedisTemplate.opsForValue().get("jiang");
        System.out.println(res);
    }
}
