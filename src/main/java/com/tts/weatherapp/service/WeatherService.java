package com.tts.weatherapp.service;

import java.util.List;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.Zipcode;
import com.tts.weatherapp.repository.ZipcodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${api_key}")
    private String apiKey;

    @Autowired
    private ZipcodeRepository zipcodeRepository;

    public List<Zipcode> getRecentSearches() {
        return zipcodeRepository.findAll();
    }

    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
                + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        Zipcode zip = new Zipcode(zipCode);
        try {
            if (zipcodeRepository.findByZip(zipCode) == null) {
                zipcodeRepository.save(zip);
            }
            return restTemplate.getForObject(url, Response.class);
        } catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
    }
}