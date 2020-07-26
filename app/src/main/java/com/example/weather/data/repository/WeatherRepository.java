package com.example.weather.data.repository;

import com.example.weather.data.remote.ServerCommunicator;
import com.example.weather.data.remote.pojo.Weather;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherRepository {

    private ServerCommunicator serverCommunicator;

    public WeatherRepository() {
        this.serverCommunicator = new ServerCommunicator();
    }

    public Single<Weather> getWeatherByCityId(int cityId, String apiKey) {
        return serverCommunicator.getWeatherByCityId(cityId, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
