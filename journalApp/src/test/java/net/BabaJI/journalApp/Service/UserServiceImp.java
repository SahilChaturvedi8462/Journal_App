package net.BabaJI.journalApp.Service;

import net.BabaJI.journalApp.Repositery.UserRepo;
import net.BabaJI.journalApp.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import net.BabaJI.journalApp.entity.User;


import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImp {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private UserRepo userRepo;

    @Test
    void loadByusernameTest() {
        when(userRepo.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder()
                        .userName("ram")
                        .password("ioshid")
                        .roles(new ArrayList<>()).build());
        UserDetails userDetails = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(userDetails);
    }
}
