package com.example.weather.ui.main.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.remote.api.ApiService;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class CityListViewModel extends BaseViewModel {

    private static final String TAG = "CityListViewModel";

    private CityRepository cityRepository;
    private MutableLiveData<List<CityEntity>> cities = new MutableLiveData<>();

    @Inject
    public CityListViewModel(CityDao cityDao, ApiService apiService) {
        cityRepository = new CityRepository(cityDao, apiService);
    }

    @SuppressLint("CheckResult")
    public void loadCities() {
        cityRepository.getAll()
                .doOnSubscribe(this::addDisposable)
                .subscribe(cityEntities -> getCities().postValue(cityEntities),
                        throwable -> Log.d(TAG, "An error happens"));
    }

    public MutableLiveData<List<CityEntity>> getCities() {
        return cities;
    }

}
