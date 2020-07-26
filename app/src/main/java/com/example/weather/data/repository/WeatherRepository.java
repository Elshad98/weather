package com.example.weather.data.repository;

import com.example.weather.data.remote.api.ApiService;
import com.example.weather.data.remote.pojo.Weather;

import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class WeatherRepository {

    private ApiService apiService;

    public WeatherRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<Weather> getWeatherByCityId(int cityId, String apiKey) {
        return apiService.getWeatherByCityId(cityId, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
