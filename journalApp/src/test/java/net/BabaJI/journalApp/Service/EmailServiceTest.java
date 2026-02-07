package net.BabaJI.journalApp.Service;

import net.BabaJI.journalApp.Repositery.UserRepoImpl;
import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.EmailService;
import net.BabaJI.journalApp.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void testSaveNewUser(){
        emailService.sendMail("besoxor833@helesco.com", "Tussi badde cute ho ji", "I love you ji🥰🥰🥰😘😘🤩");
    }
}
