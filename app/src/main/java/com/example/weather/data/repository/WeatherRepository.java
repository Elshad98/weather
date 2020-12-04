package com.example.weather.data.repository;

import androidx.lifecycle.LiveData;

import com.example.weather.data.remote.api.WeatherApiService;
import com.example.weather.data.remote.model.CurrentWeather;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class WeatherRepository {

    private final WeatherApiService weatherApiService;
    private WeatherDetailDataSource weatherDetailDataSource;

    @Inject
    public WeatherRepository(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    public LiveData<CurrentWeather> fetchSingleMovieDetails(CompositeDisposable compositeDisposable, String cityName) {
        weatherDetailDataSource = new WeatherDetailDataSource(weatherApiService, compositeDisposable);
        weatherDetailDataSource.fetchWeatherDetails(cityName);

        return weatherDetailDataSource.getCurrentWeather();
    }

    public LiveData<NetworkState> getNetworkState() {
        return weatherDetailDataSource.getNetworkState();
    }
}
