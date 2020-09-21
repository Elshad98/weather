package com.example.weather.data.repository;

import com.example.weather.data.remote.api.ApiWeather;
import com.example.weather.data.remote.api.ApiWeatherClient;
import com.example.weather.data.remote.model.CurrentWeather;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherRepository {

    private final ApiWeather apiService;

    @Inject
    public WeatherRepository(ApiWeatherClient apiWeatherClient) {
        this.apiService = apiWeatherClient.getClient();
    }

    public Single<CurrentWeather> getWeatherByCityName(String cityName) {
        return apiService.getWeatherByCityName(cityName);
    }
}
