package com.example.weather.repository.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.weather.repository.database.dao.CityDao;
import com.example.weather.repository.database.entity.CityEntity;

@Database(entities = {CityEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CityDao cityDao();
}
