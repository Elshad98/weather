package com.example.weather.viewmodel;

import androidx.databinding.ObservableField;

import com.example.weather.service.model.Weather;
import com.example.weather.service.repository.WeatherRepository;
import com.example.weather.utils.Constants;

import io.reactivex.Single;

public class WeatherViewModel {
    private final Single<Weather> currentWeatherObservable;

    public ObservableField<Weather> weather = new ObservableField<>();

    public WeatherViewModel() {
        currentWeatherObservable = WeatherRepository
                .getInstance()
                .getCurrentWeather(511196, Constants.API_KEY);
    }

    public Single<Weather> getObservableCurrentWeather() {
        return currentWeatherObservable;
    }

    public void setCurrentWeather(Weather weather) {
        this.weather.set(weather);
    }
}
