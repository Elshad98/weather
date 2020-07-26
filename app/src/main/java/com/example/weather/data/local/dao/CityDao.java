package com.example.weather.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.weather.data.local.entity.CityEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CityDao {
    @Query("SELECT * FROM cities")
    Single<List<CityEntity>> getAll();

    @Query("SELECT * FROM cities WHERE id = :id")
    Single<CityEntity> getById(int id);

    @Query("SELECT * FROM cities WHERE name = :name")
    Single<CityEntity> getByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(CityEntity cityEntity);
    
}
