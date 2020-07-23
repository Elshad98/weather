package com.example.weather.view.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.example.weather.R;
import com.example.weather.databinding.WeatherDetailsBinding;
import com.example.weather.service.model.Weather;
import com.example.weather.viewmodel.WeatherViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherFragment extends BaseFragment {

    private static final String TAG = "WeatherFragment";
    private WeatherDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_details, container, false);

        // Create and set the adapter for the RecyclerView
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        WeatherViewModel viewModel = new WeatherViewModel();

        binding.setWeatherViewModel(viewModel);

        observerViewModel(viewModel);
    }

    private void observerViewModel(final WeatherViewModel viewModel) {
        addDisposable(
                viewModel.getObservableCurrentWeather()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Weather>() {
                            @Override
                            public void accept(Weather weather) throws Exception {
                                viewModel.setCurrentWeather(weather);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d(TAG, "An error happens");
                            }
                        })
        );
    }
}
