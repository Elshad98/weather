package com.example.weather.di;

import com.example.weather.data.repository.CityRepository;

import toothpick.config.Module;

public class CityRepositoryModule extends Module {

    public CityRepositoryModule() {
        bind(CityRepository.class)
                .singleton();
    }
}
