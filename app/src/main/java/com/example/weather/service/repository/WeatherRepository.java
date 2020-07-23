package com.example.weather.service.repository;

import com.example.weather.service.model.Weather;
import com.example.weather.utils.Constants;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {

    private WeatherApi weatherApi;
    private static WeatherRepository weatherRepository;

    private WeatherRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
    }

    public synchronized static WeatherRepository getInstance() {
        if (weatherRepository == null) {
            weatherRepository = new WeatherRepository();
        }
        return weatherRepository;
    }

    public Single<Weather> getCurrentWeather(int cityId, String apiKey) {
        return weatherApi.getCurrentWeather(cityId, apiKey);
    }
}
