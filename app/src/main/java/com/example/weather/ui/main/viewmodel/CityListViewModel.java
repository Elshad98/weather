package com.example.weather.ui.main.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.repository.CityRepository;

import java.util.List;

public class CityListViewModel extends AndroidViewModel {

    private CityRepository cityRepository;

    private LiveData<List<CityEntity>> cities;

    public CityListViewModel(@NonNull Application application) {
        super(application);
        cityRepository = new CityRepository(application);
        cities = cityRepository.getAllCities();
    }

    public LiveData<List<CityEntity>> getCities() {
        return cities;
    }

    public void deleteCity(CityEntity cityEntity) {
        cityRepository.deleteCity(cityEntity);
    }

    public void insertCity(CityEntity cityEntity) {
        cityRepository.insertCity(cityEntity);
    }
}
