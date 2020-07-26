package com.example.weather.data.repository;

import android.util.Log;

import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.remote.api.ApiService;
import com.example.weather.data.remote.pojo.Weather;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class CityRepository {

    private ApiService apiService;
    private CityDao cityDao;

    public CityRepository(CityDao cityDao, ApiService apiService) {
        this.apiService = apiService;
        this.cityDao = cityDao;
    }

    public Single<Weather> getWeatherByCityName(String cityName, String apiKey) {
        return apiService.getWeatherByCityName(cityName, apiKey)
                .flatMap(weather -> {
                    cityDao.insertCity(new CityEntity(weather.getId(), weather.getName()));
                    return Single.just(weather);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<CityEntity>> getAll() {
        Log.d("TAG", "apiService: " + apiService);
        return cityDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
