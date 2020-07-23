package com.example.weather.viewmodel;

import android.app.Application;

import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

import com.example.weather.service.model.Weather;
import com.example.weather.service.repository.WeatherRepository;
import com.example.weather.utils.Constants;

import io.reactivex.Single;

public class WeatherViewModel extends AndroidViewModel {
    private final Single<Weather> currentWeatherObservable;

    public ObservableField<Weather> weather = new ObservableField<>();

    public WeatherViewModel(Application application) {
        super(application);

        currentWeatherObservable = WeatherRepository
                .getInstance()
                .getCurrentWeather(498817, Constants.API_KEY, "ru");
    }

    public Single<Weather> getCurrentWeatherObservable() {
        return currentWeatherObservable;
    }

    public void setCurrentWeather(Weather weather) {
        this.weather.set(weather);
    }
}
