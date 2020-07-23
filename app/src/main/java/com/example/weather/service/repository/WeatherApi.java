package com.example.weather.service.repository;

import com.example.weather.service.model.Find;
import com.example.weather.service.model.Weather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather?units=metric&lang=ru")
    Single<Weather> getCurrentWeather(@Query("id") int cityId,
                                      @Query("appid") String apiKey);

    @GET("find?units=metric&lang=ru")
    Single<Find> getWeatherByCityName(@Query("q") String cityName,
                                      @Query("appid") String apiKey);
}
