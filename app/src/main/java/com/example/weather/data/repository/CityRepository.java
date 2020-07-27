package com.example.weather.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.weather.data.local.AppDatabase;
import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;

import java.util.List;

public class CityRepository {

    private CityDao cityDao;
    private LiveData<List<CityEntity>> cities;

    public CityRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        cityDao = database.cityDao();
        cities = cityDao.getAllCities();
    }

    public LiveData<List<CityEntity>> getAllCities() {
        return cities;
    }

    public void deleteCity(CityEntity city) {
        AppDatabase.databaseWriteExecutor.execute(() -> cityDao.deleteCity(city));
    }

    public void insertCity(CityEntity city) {
        AppDatabase.databaseWriteExecutor.execute(() -> cityDao.insertCity(city));
    }
}

