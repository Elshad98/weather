package com.example.weather.view.ui.fragment;

import androidx.fragment.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment {
    private CompositeDisposable disposables = new CompositeDisposable();

    protected final void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    public void onDestroy() {
        disposables.dispose();
        super.onDestroy();
    }
}
