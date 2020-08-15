package com.example.weather.data.repository;

import android.app.Application;

import com.example.weather.data.local.AppDatabase;
import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CityRepository {

    private CityDao cityDao;

    public CityRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        cityDao = database.cityDao();
    }

    public Flowable<List<CityEntity>> getAllCities() {
        return cityDao.getAllCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
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

