package com.example.weather.ui.detail.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.weather.R;
import com.example.weather.data.remote.pojo.CurrentWeather;
import com.example.weather.databinding.DetailActivityBinding;
import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;
import com.example.weather.utils.Constants;
import com.squareup.picasso.Picasso;

public class WeatherDetailActivity extends AppCompatActivity {

    private DetailActivityBinding binding;
    WeatherDetailViewModel weatherDetailViewModel;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        weatherDetailViewModel = new ViewModelProvider(this).get(WeatherDetailViewModel.class);

        Intent intent = getIntent();
        String cityName = intent.getStringExtra(Constants.INTENT_CITY);
        weatherDetailViewModel.getWeatherByCityName(cityName, Constants.API_KEY)
                .subscribe(this::updateWeatherDetailView,
                        (throwable) -> binding.description.setText(throwable.getMessage()));
    }

    private void updateWeatherDetailView(CurrentWeather currentWeather) {
        CurrentWeather.Weather weather = currentWeather.getWeather().get(0);
        String url = String.format(Constants.IMAGE_URL, weather.getIcon());
        Picasso.get().load(url).into(binding.icon);
        binding.name.setText(currentWeather.getName());
        binding.temp.setText(currentWeather.getMain().getTemp() + "°C");
        binding.description.setText(weather.getDescription());
        binding.feelsLike.setText("Ощущается как " + currentWeather.getMain().getFeelsLike() +  "°C");
    }
}
