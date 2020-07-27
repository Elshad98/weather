package com.example.weather.data.remote.api;

import com.example.weather.data.remote.pojo.CurrentWeather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather?units=metric&lang=ru")
    Single<CurrentWeather> getWeatherByCityId(@Query("id") int cityId,
                                              @Query("appid") String apiKey);

    @GET("weather?units=metric&lang=ru")
    Single<CurrentWeather> getWeatherByCityName(@Query("q") String cityName,
                                                @Query("appid") String apiKey);


}

