package net.BabaJI.journalApp.Cache;

import jakarta.annotation.PostConstruct;
import net.BabaJI.journalApp.Repositery.ConfigJournalAppRepo;
import net.BabaJI.journalApp.entity.ConfigJournalAppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    public Map<String, String> APP_CACHE;

    @PostConstruct
    public void inti() {
        APP_CACHE = new HashMap<>();//if we change anything in data base like name of key oor something we don't need to re run full aplication we can just create api to run thise method and by hitting it we ca reset everything again
        List<ConfigJournalAppEntity> all = configJournalAppRepo.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity : all) {
            APP_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }
}