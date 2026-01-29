package net.BabaJI.journalApp.Controller;

import net.BabaJI.journalApp.entity.User;
import net.BabaJI.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if (all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin")
    public void creatAdmin(@RequestBody User user){
        userService.saveAdmin(user);
    }
}
