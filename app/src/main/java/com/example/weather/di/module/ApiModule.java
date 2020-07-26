package com.example.weather.di.module;

import com.example.weather.data.remote.api.ApiService;
import com.example.weather.data.repository.CityRepository;
import com.example.weather.data.repository.WeatherRepository;
import com.example.weather.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    CityRepository provideCityApiService(Retrofit retrofit) {
        return retrofit.create(CityRepository.class);
    }

    @Provides
    @Singleton
    WeatherRepository provideWeatherApiService(Retrofit retrofit) {
        return retrofit.create(WeatherRepository.class);
    }
}
