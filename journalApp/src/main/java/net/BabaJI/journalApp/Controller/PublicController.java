package net.BabaJI.journalApp.Controller;

import net.BabaJI.journalApp.Repositery.UserRepoImpl;
import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.EmailService;
import net.BabaJI.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepoImpl userRepo;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User userData){
        boolean b = userService.saveNewEntry(userData);
        if (b){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/send-mail")
    public void sendMail(){
        emailService.sendMail("besoxor833@helesco.com", "aami tuma k bhalo bhashi", "or meri jaan kais ho😘😘😘🥰😋");
    }
}
