package net.BabaJI.journalApp.Repositery;

import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(properties = {
        "spring.data.mongodb.uri=${MONGODB_URI}",
        "spring.data.mongodb.database=journadb"
})

public class UserRepoImplTest {
    @Autowired
    private UserRepoImpl userRepoimpl;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void testSaveNewUser(){
        List<User> users = userRepoimpl.getUserForSA();
        Assertions.assertFalse(users.isEmpty());
    }
}
