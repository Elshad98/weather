package com.example.weather.repository;

import com.example.weather.repository.database.dao.CityDao;
import com.example.weather.repository.database.entity.CityEntity;
import com.example.weather.repository.server.ServerCommunicator;
import com.example.weather.repository.server.pojo.Weather;

import java.util.Objects;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppRepository {
    private ServerCommunicator serverCommunicator;
    private CityDao database;

    public AppRepository(ServerCommunicator serverCommunicator, CityDao database) {
        this.serverCommunicator = serverCommunicator;
        this.database = database;
    }

    public Single<Weather> getWeatherByCityName(String cityName, String apiKey) {
        return serverCommunicator.getWeatherByCityName(cityName, apiKey)
                .flatMap(weather -> {
                    database.insertCity(new CityEntity(
                            weather.getId(),
                            weather.getName(),
                            weather.getSys().getCountry()));
                    return Single.just(weather);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Weather> getWeatherByCityId(int cityId, String apiKey) {
        return serverCommunicator.getWeatherByCityId(cityId, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
