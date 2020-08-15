package com.example.weather.ui.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends AndroidViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    protected void addToDisposable(Disposable disposable) {
        compositeDisposable.remove(disposable);
        compositeDisposable.add(disposable);
    }

    public void onStop() {
        compositeDisposable.clear();
    }
}
