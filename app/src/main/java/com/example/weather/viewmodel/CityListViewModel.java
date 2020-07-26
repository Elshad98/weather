package com.example.weather.viewmodel;

import androidx.databinding.ObservableField;

import com.example.weather.service.model.Find;

public class CityListViewModel {
    // private final Single<List<CityEntity>> cityListObservable;

    public ObservableField<Find> cityWeather = new ObservableField<>();

    public CityListViewModel() {
//        cityListObservable = City
//                .getInstance()
//                .getWeatherByCityName("Пермь", Constants.API_KEY);
    }

//    public Single<Find> getObservableCityWeather() {
//        return cityWeatherObservable;
//    }
//
//    public void setCityWeather(Find find) {
//        this.cityWeather.set(find);
//    }

}
