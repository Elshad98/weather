package com.example.weather.di;

import com.example.weather.data.local.AppDatabase;
import com.example.weather.data.local.dao.CityDao;

import javax.inject.Inject;
import javax.inject.Provider;

public class CityDaoProvider implements Provider<CityDao> {

    private final AppDatabase appDatabase;

    @Inject
    public CityDaoProvider(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public CityDao get() {
        return appDatabase.cityDao();
    }
}
