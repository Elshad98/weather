package com.example.weather.di;

import com.example.weather.data.remote.api.ApiWeatherClient;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.data.repository.WeatherRepository;
import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;
import com.example.weather.ui.main.viewmodel.CityListViewModel;

import toothpick.config.Module;

public class AppModule extends Module {

    public AppModule() {
        bind(WeatherRepository.class).singleton();
        bind(CityRepository.class).singleton();
        bind(ApiWeatherClient.class).singleton();
        bind(CityListViewModel.class).singleton();
        bind(WeatherDetailViewModel.class).singleton();
    }
}
