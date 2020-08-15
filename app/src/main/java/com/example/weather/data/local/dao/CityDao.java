package com.example.weather.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.weather.data.local.entity.CityEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CityDao {
    @Query("SELECT * from cities")
    Flowable<List<CityEntity>> getAllCities();

    @Query("SELECT * FROM cities WHERE id = :id")
    List<CityEntity> getById(int id);

    @Query("SELECT * FROM Cities LIMIT 1")
    List<CityEntity> getCity();

    @Delete
    void deleteCity(CityEntity city);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCity(CityEntity city);
}
