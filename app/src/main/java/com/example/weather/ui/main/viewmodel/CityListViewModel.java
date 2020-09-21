package com.example.weather.ui.main.viewmodel;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CityListViewModel extends BaseViewModel {

    private CityRepository cityRepository;

    @Inject
    public CityListViewModel(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Flowable<List<CityEntity>> getCities() {
        return cityRepository.getAllCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void deleteCity(CityEntity cityEntity) {
        cityRepository.deleteCity(cityEntity);
    }

    public void insertCity(CityEntity cityEntity) {
        cityRepository.insertCity(cityEntity);
    }
}
