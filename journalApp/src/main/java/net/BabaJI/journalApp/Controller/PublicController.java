package net.BabaJI.journalApp.Controller;

import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User userData){
        userService.saveNewEntry(userData);
    }
}
