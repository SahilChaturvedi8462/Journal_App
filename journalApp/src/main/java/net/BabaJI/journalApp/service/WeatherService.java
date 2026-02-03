package net.BabaJI.journalApp.service;

import net.BabaJI.journalApp.ResponseAPI.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apiKey = "4df1653934334d01a9351245260302";
    private static final String API= "https://api.weatherapi.com/v1/current.json?key=Acces_Key&q=CITY&aqi=no";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponse getWeather(String city){
        String finalAPI = API.replace("CITY", city).replace("Acces_Key", apiKey);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
