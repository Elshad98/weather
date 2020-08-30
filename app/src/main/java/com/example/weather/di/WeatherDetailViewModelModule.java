package com.example.weather.di;

import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;

import toothpick.config.Module;

public class WeatherDetailViewModelModule extends Module {

    public WeatherDetailViewModelModule() {
        bind(WeatherDetailViewModel.class)
                .singleton();
    }
}
