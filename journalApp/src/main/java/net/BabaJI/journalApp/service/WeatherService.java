package net.BabaJI.journalApp.service;

import net.BabaJI.journalApp.Cache.AppCache;
import net.BabaJI.journalApp.ResponseAPI.WeatherResponse;
import net.BabaJI.journalApp.entity.ConfigJournalAppEntity;
import net.BabaJI.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    private String API;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;


    public WeatherResponse getWeather(String city) {
        String finalAPI = appCache.APP_CACHE.get("weatherApi").replace("<city>", city).replace("<apiKey>", apiKey);

//        String requestBody = "{\n" +
//                "\n  \"userName\" : \"rani\",\n" +
//                "\n  \"password\" : \"rani\"\n" +
//                "}    "; like thise or
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key", "value");
//        User user = User.builder().userName("babu").password("dakait").build();
//        HttpEntity<User> httpEntity = new HttpEntity<>(user);
//        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
//        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}