package net.BabaJI.journalApp.Controller;

import net.BabaJI.journalApp.Repositery.UserRepoImpl;
import net.BabaJI.journalApp.entity.User;
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

    @GetMapping("/get")
    public List<User> getThose(){
        return userRepo.getUserForSA();
    }
}
