package com.example.weather.data.repository;

import com.example.weather.data.remote.api.ApiService;
import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.utils.Constants;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {

    private ApiService apiService;

    public WeatherRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public Single<CurrentWeather> getWeatherByCityName(String cityName, String apiKey) {
        return apiService.getWeatherByCityName(cityName, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
