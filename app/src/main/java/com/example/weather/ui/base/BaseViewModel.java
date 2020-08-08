package com.example.weather.ui.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;

    protected void addToDisposable() {

    }
}
