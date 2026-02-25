package net.BabaJI.journalApp.Controller;

import lombok.extern.slf4j.Slf4j;
import net.BabaJI.journalApp.Repositery.UserRepoImpl;
import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.EmailService;
import net.BabaJI.journalApp.service.UserDetailsServiceImpl;
import net.BabaJI.journalApp.service.UserService;
import net.BabaJI.journalApp.utilis.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepoImpl userRepo;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User userData){
        boolean b = userService.saveNewEntry(userData);
        if (b){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/log-in")
    public ResponseEntity<String> logIn(@RequestBody User userData){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userData.getUserName(), userData.getPassword()));
            userDetailsService.loadUserByUsername(userData.getUserName());
            String jwt = jwtUtil.generateToken(userData.getUserName());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (AuthenticationException e) {
            log.error("Exception occured while creating Token ", e);
            return new ResponseEntity<>("Incorrect UserName or Password", HttpStatus.BAD_REQUEST);
        }

    }

}
