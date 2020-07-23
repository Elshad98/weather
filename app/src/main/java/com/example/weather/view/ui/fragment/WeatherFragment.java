package com.example.weather.view.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.weather.R;
import com.example.weather.databinding.WeatherDetailsBinding;
import com.example.weather.service.model.Weather;
import com.example.weather.viewmodel.WeatherViewModel;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherFragment extends BaseFragment {

    private static final String TAG = "WeatherFragment";
    private WeatherDetailsBinding binding;

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        WeatherViewModel viewModel = new WeatherViewModel(getActivity().getApplication());

        binding.setWeatherViewModel(viewModel);

        observerViewModel(viewModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_details, container, false);

        // Create and set the adapter for the RecyclerView
        return binding.getRoot();
    }

    private void observerViewModel(final WeatherViewModel viewModel) {
        addDisposable(
                viewModel.getCurrentWeatherObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Weather>() {
                    @Override
                    public void accept(Weather weather) throws Exception {
                        Log.d(TAG, "Weather: " + weather.getWeather().get(0).getDescription());
                        Log.d(TAG, "Weather: " + weather.getName());
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
