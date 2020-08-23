package com.example.weather.ui.detail.viewmodel;

import android.app.Application;

import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.data.repository.WeatherRepository;
import com.example.weather.ui.base.BaseViewModel;

import io.reactivex.Single;

public class WeatherDetailViewModel extends BaseViewModel {

    private WeatherRepository weatherRepository;

    public WeatherDetailViewModel(Application application) {
        super(application);
        weatherRepository = new WeatherRepository();
    }

    public Single<CurrentWeather> getWeatherByCityName(String cityName, String apiKey) {
        return weatherRepository.getWeatherByCityName(cityName, apiKey)
                .doOnSubscribe(this::addToDisposable);
    }
}
