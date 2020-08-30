package com.example.weather.di;

import toothpick.config.Module;

public class CityListViewModelModule extends Module {

    public CityListViewModelModule() {
        bind(CityRepositoryModule.class)
                .singleton();
    }
}
