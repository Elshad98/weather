package com.example.weather.di;

import android.content.Context;

import com.example.weather.App;
import com.example.weather.data.local.AppDatabase;
import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.remote.api.WeatherApiService;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.data.repository.WeatherRepository;

import toothpick.config.Module;

public class AppModule extends Module {

    public AppModule(App app) {
        bind(Context.class).toInstance(app);
        bind(WeatherRepository.class).singleton();
        bind(CityRepository.class).singleton();
        bind(WeatherApiService.class).toProvider(WeatherApiServiceProvider.class)
                .providesSingleton();
        bind(AppDatabase.class).toProvider(AppDatabaseProvider.class)
                .providesSingleton();
        bind(CityDao.class).toProvider(CityDaoProvider.class)
                .providesSingleton();
    }
}