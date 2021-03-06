package com.example.weather.data.remote.api;

import com.example.weather.data.remote.model.CurrentWeather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    @GET("weather?units=metric")
    Single<CurrentWeather> getWeatherByCityId(@Query("id") int cityId);

    @GET("weather?units=metric")
    Single<CurrentWeather> getWeatherByCityName(@Query("q") String cityName);
}

