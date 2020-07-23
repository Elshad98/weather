package com.example.weather.service.repository;

import com.example.weather.service.model.Weather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather")
    Single<Weather> getCurrentWeather(@Query("id") int cityId,
                                      @Query("appid") String apiKey,
                                      @Query("lang") String lang);
}
