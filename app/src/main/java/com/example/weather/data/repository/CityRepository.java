package com.example.weather.data.repository;

import com.example.weather.App;
import com.example.weather.data.local.AppDatabase;
import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class CityRepository {

    private CityDao cityDao;

    @Inject
    public CityRepository() {
        AppDatabase database = AppDatabase.getInstance(App.instance());
        cityDao = database.cityDao();
    }

    public Flowable<List<CityEntity>> getAllCities() {
        return cityDao.getAllCities();
    }

    public void deleteCity(CityEntity city) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> cityDao.deleteCity(city));
    }

    public void insertCity(CityEntity city) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> cityDao.insertCity(city));
    }
}

