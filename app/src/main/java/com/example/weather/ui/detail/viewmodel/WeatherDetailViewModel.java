package com.example.weather.ui.detail.viewmodel;

import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.data.repository.WeatherRepository;
import com.example.weather.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherDetailViewModel extends BaseViewModel {

    private WeatherRepository weatherRepository;

    @Inject
    public WeatherDetailViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Single<CurrentWeather> getWeatherByCityName(String cityName, String apiKey) {
        return weatherRepository.getWeatherByCityName(cityName, apiKey)
                .doOnSubscribe(this::addToDisposable);
    }
}
