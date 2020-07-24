package com.example.weather.repository.server;

import com.example.weather.repository.server.pojo.Weather;
import com.example.weather.service.repository.WeatherApi;
import com.example.weather.utils.Constants;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerCommunicator {
    private ApiService service;

    public ServerCommunicator() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(ApiService.class);
    }

    public Single<Weather> getWeatherByCityId(int id, String apiKey) {
        return service.getWeatherByCityId(id, apiKey);
    }

    public Single<Weather> getWeatherByCityName(String cityName, String apiKey) {
        return service.getWeatherByCityName(cityName, apiKey);
    }
}
