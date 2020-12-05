package com.example.weather.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CityRepository {

    private final CityDao cityDao;
    private final MutableLiveData<List<CityEntity>> cities = new MutableLiveData<>();

    @Inject
    public CityRepository(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public Disposable getAllCities() {
        return cityDao.getAllCities()
                .subscribeOn(Schedulers.io())
                .subscribe(cities::postValue);
    }

    public void deleteCity(CityEntity city) {
        Completable.fromAction(() -> {
            cityDao.deleteCity(city);
        }).subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void insertCity(CityEntity city) {
        Completable.fromAction(() -> {
            CityEntity cityEntity = cityDao.getCityByName(city.getName());
            if (cityEntity == null) {
                cityDao.insertCity(city);
            }
        }).subscribeOn(Schedulers.io())
                .subscribe();
    }

    public LiveData<List<CityEntity>> getCities() {
        return cities;
    }
}

