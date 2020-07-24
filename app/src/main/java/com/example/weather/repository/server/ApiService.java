package com.example.weather.repository.server;

import com.example.weather.repository.server.pojo.Weather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("weather?units=metric&lang=ru")
    Single<Weather> getWeatherByCityId(@Query("id") int cityId,
                                       @Query("appid") String apiKey);

    @GET("weather?units=metric&lang=ru")
    Single<Weather> getWeatherByCityName(@Query("q") String cityName,
                                      @Query("appid") String apiKey);
}
