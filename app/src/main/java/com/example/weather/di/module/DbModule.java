package com.example.weather.di.module;

import android.app.Application;

import androidx.room.Room;

import com.example.weather.data.local.AppDatabase;
import com.example.weather.data.local.dao.CityDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "database.db")
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    CityDao provideCityDao(AppDatabase appDatabase) {
        return appDatabase.cityDao();
    }
    
}
