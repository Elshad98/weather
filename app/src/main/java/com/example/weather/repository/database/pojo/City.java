package com.example.weather.repository.database.pojo;

import com.example.weather.repository.database.entity.CityEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class City {
    @SerializedName("records")
    private List<CityEntity> mRecords;

    public List<CityEntity> getRecords() {
        return mRecords;
    }

    public void setRecords(List<CityEntity> mRecords) {
        this.mRecords = mRecords;
    }
}
