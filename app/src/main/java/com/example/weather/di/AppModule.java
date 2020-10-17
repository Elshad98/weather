package com.example.weather.di;

import com.example.weather.data.remote.api.ApiWeatherClient;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.data.repository.WeatherRepository;

import toothpick.config.Module;

public class AppModule extends Module {

    public AppModule() {
        bind(WeatherRepository.class).singleton();
        bind(CityRepository.class).singleton();
        bind(ApiWeatherClient.class).singleton();
    }
}