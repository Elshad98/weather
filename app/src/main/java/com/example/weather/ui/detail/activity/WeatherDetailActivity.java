package com.example.weather.ui.detail.activity;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.weather.App;
import com.example.weather.R;
import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.data.repository.NetworkState;
import com.example.weather.databinding.DetailActivityBinding;
import com.example.weather.ui.base.BaseActivity;
import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;
import com.example.weather.ui.main.activity.MainActivity;
import com.squareup.picasso.Picasso;

public class WeatherDetailActivity extends BaseActivity {

    private DetailActivityBinding binding;
    private WeatherDetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        String cityName = getIntent().getStringExtra(MainActivity.EXTRA_CITY);
        viewModel = viewModel(WeatherDetailViewModel.class, App.scope());
        viewModel.getCurrentWeather(cityName).observe(this, this::onSuccess);
        viewModel.getNetworkState().observe(this, networkState -> {
            binding.progressBar.setVisibility(networkState == NetworkState.LOADING ? View.VISIBLE : View.GONE);
            binding.errorMessage.setVisibility(networkState == NetworkState.ERROR ? View.VISIBLE : View.GONE);
        });
    }

    private void onSuccess(CurrentWeather currentWeather) {
        CurrentWeather.Weather weather = currentWeather.getWeather().get(0);
        Picasso.get().load(weather.getIcon()).into(binding.icon);
        binding.date.setText(currentWeather.getDt());
        binding.description.setText(weather.getDescription());
        binding.cityName.setText(currentWeather.getFullName());
        binding.temp.setText(currentWeather.getMain().getTemp());
        binding.wind.setText(currentWeather.getWind().getSpeed());
        binding.visibility.setText(currentWeather.getVisibility());
        binding.tempMin.setText(currentWeather.getMain().getTempMin());
        binding.tempMax.setText(currentWeather.getMain().getTempMax());
        binding.humidity.setText(currentWeather.getMain().getHumidity());
        binding.pressure.setText(currentWeather.getMain().getPressure());
        binding.feelsLike.setText(currentWeather.getMain().getFeelsLike());
        binding.location.setVisibility(View.VISIBLE);
        binding.arrowTop.setVisibility(View.VISIBLE);
        binding.arrowDown.setVisibility(View.VISIBLE);
        binding.horizontalScroll.setVisibility(View.VISIBLE);
    }
}
