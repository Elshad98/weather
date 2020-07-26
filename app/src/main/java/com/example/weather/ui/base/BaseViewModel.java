package com.example.weather.ui.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();

    protected final void addDisposable(Disposable disposable) {
        disposables.remove(disposable);
        disposables.add(disposable);
    }

    public void onStop() {
        disposables.clear();
    }
}
