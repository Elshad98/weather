package com.example.weather.data.repository;

import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.remote.ServerCommunicator;
import com.example.weather.data.remote.pojo.Weather;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CityRepository {

    private ServerCommunicator serverCommunicator;
    private CityDao database;

    public CityRepository() {
        this.serverCommunicator = new ServerCommunicator();
    }

    public Single<Weather> getWeatherByCityName(String cityName, String apiKey) {
        return serverCommunicator.getWeatherByCityName(cityName, apiKey)
                .flatMap(weather -> {
                    database.insertCity(new CityEntity(weather.getId(), weather.getName()));
                    return Single.just(weather);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<CityEntity>> getAll() {
        return database.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
