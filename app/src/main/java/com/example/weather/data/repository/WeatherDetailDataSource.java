package com.example.weather.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weather.data.remote.api.WeatherApiService;
import com.example.weather.data.remote.model.CurrentWeather;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherDetailDataSource {

    private static final String TAG = "WeatherDetailDataSource";

    private final WeatherApiService weatherApiService;
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private final MutableLiveData<CurrentWeather> currentWeather = new MutableLiveData<>();

    public WeatherDetailDataSource(WeatherApiService weatherApiService, CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
        this.weatherApiService = weatherApiService;
    }

    public void fetchWeatherDetails(String cityName) {
        networkState.postValue(NetworkState.LOADING);

        try {
            compositeDisposable.add(
                    weatherApiService.getWeatherByCityName(cityName)
                            .subscribeOn(Schedulers.io())
                            .subscribe(
                                    response -> {
                                        networkState.postValue(NetworkState.LOADED);
                                        currentWeather.postValue(response);
                                    },
                                    throwable -> {
                                        networkState.postValue(NetworkState.ERROR);
                                        Log.e(TAG, throwable.getMessage());
                                    }
                            )
            );
        } catch (Exception exc) {
            Log.e(TAG, exc.getMessage());
        }
    }

    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public LiveData<CurrentWeather> getCurrentWeather() {
        return currentWeather;
    }
}
