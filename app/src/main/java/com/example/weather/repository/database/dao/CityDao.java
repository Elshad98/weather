package com.example.weather.repository.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.weather.repository.database.entity.CityEntity;

import java.util.List;

@Dao
public interface CityDao {
    @Query("SELECT * FROM cities")
    List<CityEntity> getAll();

    @Query("SELECT * FROM cities WHERE id = :id")
    CityEntity getById(int id);

    @Query("SELECT * FROM cities WHERE name = :name")
    CityEntity getByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(CityEntity cityEntity);

    @Delete
    void delete(CityEntity cityEntity);
}
