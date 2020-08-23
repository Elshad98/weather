package com.example.weather.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "cities")
public class CityEntity {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    private String name;

    public CityEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
