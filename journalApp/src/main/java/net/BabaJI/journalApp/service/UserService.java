package net.BabaJI.journalApp.service;

import net.BabaJI.journalApp.Repositery.UserRepo;
import net.BabaJI.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    //spring will create implementation of
    // that interface for us

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user) {
        userRepo.save(user);
    }

    public void saveNewEntry(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepo.save(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public Optional<User> findbyId(ObjectId myEntry){
        return userRepo.findById(myEntry);
    }

    public void deleteById(ObjectId myId){
        userRepo.deleteById(myId);
    }

    public User getuserbyusername(String username){
        return userRepo.findByUserName(username);
    }
}
