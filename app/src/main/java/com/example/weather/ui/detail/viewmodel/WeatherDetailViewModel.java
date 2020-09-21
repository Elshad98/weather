package com.example.weather.ui.detail.viewmodel;

import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.data.repository.WeatherRepository;
import com.example.weather.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherDetailViewModel extends BaseViewModel {

    private WeatherRepository weatherRepository;

    @Inject
    public WeatherDetailViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Single<CurrentWeather> getWeatherByCityName(String cityName) {
        return weatherRepository.getWeatherByCityName(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(this::addToDisposable);
    }
}
