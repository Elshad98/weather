package com.example.weather.di.module;

import android.app.Application;

import androidx.annotation.NonNull;
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
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    CityDao provideCityDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.cityDao();
    }
    
}
