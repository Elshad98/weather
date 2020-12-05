package com.example.weather.ui.main.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class CityListViewModel extends BaseViewModel {

    private final CityRepository cityRepository;

    @Inject
    public CityListViewModel(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void loadFromDb() {
        cityRepository.getAllCities();
    }

    public LiveData<List<CityEntity>> getCities() {
        return cityRepository.getCities();
    }

    public void deleteCity(CityEntity cityEntity) {
        cityRepository.deleteCity(cityEntity);
    }

    public void insertCity(CityEntity cityEntity) {
        cityRepository.insertCity(cityEntity);
    }
}
