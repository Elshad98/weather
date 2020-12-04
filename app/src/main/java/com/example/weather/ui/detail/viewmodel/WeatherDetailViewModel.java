package com.example.weather.ui.detail.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.data.repository.NetworkState;
import com.example.weather.data.repository.WeatherRepository;
import com.example.weather.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class WeatherDetailViewModel extends BaseViewModel {

    private final WeatherRepository weatherRepository;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public WeatherDetailViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public LiveData<CurrentWeather> getCurrentWeather(String cityName) {
        return weatherRepository.fetchSingleMovieDetails(compositeDisposable, cityName);
    }

    public LiveData<NetworkState> getNetworkState() {
        return weatherRepository.getNetworkState();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
