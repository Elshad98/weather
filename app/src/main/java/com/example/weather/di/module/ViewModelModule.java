package com.example.weather.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.weather.factory.ViewModelFactory;
import com.example.weather.ui.main.viewmodel.CityListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(CityListViewModel.class)
    protected abstract ViewModel cityListViewModule(CityListViewModel cityListViewModel);

}
