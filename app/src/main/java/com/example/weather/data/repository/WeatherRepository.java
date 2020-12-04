package com.example.weather.data.repository;

import com.example.weather.data.remote.api.WeatherApiService;
import com.example.weather.data.remote.model.CurrentWeather;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherRepository {

    private final WeatherApiService weatherApiService;

    @Inject
    public WeatherRepository(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    public Single<CurrentWeather> getWeatherByCityName(String cityName) {
        return weatherApiService.getWeatherByCityName(cityName);
    }
}
