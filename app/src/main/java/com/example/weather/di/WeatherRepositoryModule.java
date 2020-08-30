package com.example.weather.di;

import com.example.weather.data.repository.WeatherRepository;

import toothpick.config.Module;

public class WeatherRepositoryModule extends Module {

    public WeatherRepositoryModule() {
        bind(WeatherRepository.class)
                .singleton();
    }
}
