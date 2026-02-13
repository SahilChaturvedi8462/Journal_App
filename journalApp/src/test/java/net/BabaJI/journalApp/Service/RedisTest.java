package net.BabaJI.journalApp.Service;

import net.BabaJI.journalApp.service.EmailService;
import net.BabaJI.journalApp.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @MockBean
    private WeatherService weatherService;

    @MockBean
    private EmailService emailService;

    @Test
    void testRedis(){
        redisTemplate.opsForValue().set("email", "sahil@email.com");
        Object salary = redisTemplate.opsForValue().get("salary");
        int a =1;
    }
}
