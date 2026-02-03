package net.BabaJI.journalApp.Controller;

import net.BabaJI.journalApp.Repositery.UserRepo;
import net.BabaJI.journalApp.ResponseAPI.WeatherResponse;
import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.UserService;
import net.BabaJI.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getName();
        User userIndb = userService.getuserbyusername(userName);

        userIndb.setUserName(user.getUserName());
        userIndb.setPassword(user.getPassword());
        userService.saveNewEntry(userIndb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserByusername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Indore");
        String greeting = "";
        if (weatherResponse != null){
            greeting = " weather feels like : "+ weatherResponse.getCurrent().getFeelslike_c();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }
}
