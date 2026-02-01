package net.BabaJI.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.BabaJI.journalApp.Repositery.UserRepo;
import net.BabaJI.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;
    //spring will create implementation of
    // that interface for us

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public void saveEntry(User user) {
        userRepo.save(user);
    }

    public boolean saveNewEntry(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error occured: ");
            log.info("yeah baby fuck you");
            log.warn("yeah baby fuck you");
            log.debug("yeah baby fuck you");
            log.trace("yeah baby fuck you");
            return false;
        }
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepo.save(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public Optional<User> findbyId(ObjectId myEntry) {
        return userRepo.findById(myEntry);
    }

    public void deleteById(ObjectId myId) {
        userRepo.deleteById(myId);
    }

    public User getuserbyusername(String username) {
        return userRepo.findByUserName(username);
    }
}
