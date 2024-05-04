package com.openAPI.weather;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openAPI.weather.entity.DetailedWeatherData;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @GetMapping("/weather/{city}")
//    public DetailedWeatherData getWeather(@PathVariable String city) {
//        String apiKey = "8a42a30652205ea085c8a22122f8edc0"; // Replace with your OpenWeatherMap API key
//        return weatherService.getWeather(city, apiKey);
//    }
    
    
    
    
    @GetMapping("/weather/{city}")
    public ResponseEntity<DetailedWeatherData> getWeather(@PathVariable String city) {
        DetailedWeatherData data = weatherService.getWeather(city, "8a42a30652205ea085c8a22122f8edc0");
        return ResponseEntity.ok(data); // This ensures JSON content type
    }
//    
//    @GetMapping("/weather/{city}")
//    public ResponseEntity<DetailedWeatherData> getWeather(@PathVariable String city) {
//        DetailedWeatherData data = weatherService.getWeather(city, "YOUR_API_KEY");
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_JSON) // Ensures the content type is JSON
//                .body(data);
//    }

    
}
