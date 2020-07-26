package com.example.weather.di.module;

import com.example.weather.ui.main.fragment.CityListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract CityListFragment contributeCityListFragment();
}
