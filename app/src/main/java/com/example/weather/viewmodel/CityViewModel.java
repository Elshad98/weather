package com.example.weather.viewmodel;

import androidx.databinding.ObservableField;

import com.example.weather.service.model.Find;
import com.example.weather.service.repository.WeatherRepository;
import com.example.weather.utils.Constants;

import io.reactivex.Single;

public class CityViewModel {
    private final Single<Find> cityWeatherObservable;

    public ObservableField<Find> cityWeather = new ObservableField<>();

    public CityViewModel() {
        cityWeatherObservable = WeatherRepository
                .getInstance()
                .getWeatherByCityName("Пермь", Constants.API_KEY);
    }

    public Single<Find> getObservableCityWeather() {
        return cityWeatherObservable;
    }

    public void setCityWeather(Find find) {
        this.cityWeather.set(find);
    }

}
