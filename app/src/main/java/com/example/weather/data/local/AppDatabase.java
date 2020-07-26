package com.example.weather.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;

@Database(entities = {CityEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CityDao cityDao();
}
