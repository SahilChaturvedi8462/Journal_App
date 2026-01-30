package net.BabaJI.journalApp.Service;

import net.BabaJI.journalApp.Repositery.UserRepo;
import net.BabaJI.journalApp.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepo userRepo;


    @Test
    public void testFindByUserName() {
//        User user = new User("Sahil", "Sahil");
//        userRepo.save(user);
        assertNotNull(userRepo.findByUserName("Sahil"));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,2,4",
            "3,4,3"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
