package com.example.weather.ui.main.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.databinding.ObservableField;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.service.model.Weather;
import com.example.weather.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CityListViewModel extends BaseViewModel {

    private static final String TAG = "CityListViewModel";

    private CityRepository cityRepository;
    private ObservableField<List<CityEntity>> cities = new ObservableField<>();

    public CityListViewModel() {
        cityRepository = new CityRepository();
    }

    @SuppressLint("CheckResult")
    public void loadCities() {
        cityRepository.getAll()
                .doOnSubscribe(this::addDisposable)
                .subscribe(cityEntities -> cities.set(cityEntities),
                        throwable -> Log.d(TAG, "An error happens"));
    }

    public ObservableField<List<CityEntity>> getCities() {
        return cities;
    }
}
