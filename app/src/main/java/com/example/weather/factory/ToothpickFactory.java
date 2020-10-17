package com.example.weather.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import toothpick.Scope;

public class ToothpickFactory implements ViewModelProvider.Factory {

    private final Scope viewModelScope;

    public ToothpickFactory(Scope viewModelScope) {
        this.viewModelScope = viewModelScope;
    }

    @Override
    public <R extends ViewModel> R create(Class<R> modelClass) {
        return viewModelScope.getInstance(modelClass);
    }
}
