package com.example.weather.ui.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addToDisposable(Disposable disposable) {
        compositeDisposable.remove(disposable);
        compositeDisposable.add(disposable);
    }

    public void onStop() {
        compositeDisposable.clear();
    }
}
