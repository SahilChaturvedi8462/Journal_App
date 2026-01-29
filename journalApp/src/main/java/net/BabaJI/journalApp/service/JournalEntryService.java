package net.BabaJI.journalApp.service;

import net.BabaJI.journalApp.Repositery.JournalEntryRepo;
import net.BabaJI.journalApp.entity.JournalEntry;
import net.BabaJI.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;
    //spring will create implementation of
    // that interface for us

    @Autowired
    private  UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        try{
        User user = userService.getuserbyusername(username);
        JournalEntry saved = journalEntryRepo.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);}
        catch (Exception e){
            System.out.println("error occured");
            throw new RuntimeException("An error occured while saving the entry",e);
        }
    }
    public void save(JournalEntry journalEntry) {
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findbyId(ObjectId myEntry){
        return journalEntryRepo.findById(myEntry);
    }

    @Transactional
    public boolean deleteById(ObjectId myId, String username){
        try {
            User user = userService.getuserbyusername(username);
            boolean removed = user.getJournalEntries().removeIf(x -> x.getId().equals(myId));
            if (removed){
            userService.saveEntry(user);
            journalEntryRepo.deleteById(myId);
            }
            return removed;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry.", e);
        }
    }
}
