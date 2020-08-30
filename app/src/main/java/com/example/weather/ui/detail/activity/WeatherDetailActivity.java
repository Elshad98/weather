package com.example.weather.ui.detail.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.weather.App;
import com.example.weather.BuildConfig;
import com.example.weather.R;
import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.databinding.DetailActivityBinding;
import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;
import com.example.weather.utils.DateFormatter;
import com.example.weather.utils.HumidityFormatter;
import com.example.weather.utils.PressureFormatter;
import com.example.weather.utils.TemperatureFormatter;
import com.example.weather.utils.VisibilityFormatter;
import com.example.weather.utils.WindFormatter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import toothpick.Toothpick;

public class WeatherDetailActivity extends AppCompatActivity {

    private DetailActivityBinding binding;

    @Inject
    WeatherDetailViewModel weatherDetailViewModel;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        Toothpick.inject(this, App.scope());

        Intent intent = getIntent();
        String cityName = intent.getStringExtra(BuildConfig.INTENT_CITY);
        weatherDetailViewModel.getWeatherByCityName(cityName, BuildConfig.API_KEY)
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(CurrentWeather currentWeather) {
        CurrentWeather.Weather weather = currentWeather.getWeather().get(0);
        Picasso.get().load(weather.getIcon()).into(binding.icon);
        binding.cityName.setText(currentWeather.getFullName());
        binding.tempMax.setText(TemperatureFormatter.format(currentWeather.getMain().getTempMax()));
        binding.tempMin.setText(TemperatureFormatter.format(currentWeather.getMain().getTempMin()));
        binding.temp.setText(TemperatureFormatter.format(currentWeather.getMain().getTemp()));
        binding.description.setText(weather.getDescription());
        binding.feelsLike.setText(TemperatureFormatter.format(currentWeather.getMain().getFeelsLike()));
        binding.humidity.setText(HumidityFormatter.format(currentWeather.getMain().getHumidity()));
        binding.wind.setText(WindFormatter.format(currentWeather.getWind().getSpeed()));
        binding.pressure.setText(PressureFormatter.format(currentWeather.getMain().getPressure()));
        binding.visibility.setText(VisibilityFormatter.format(currentWeather.getVisibility()));
        binding.date.setText(DateFormatter.format(currentWeather.getDt()));
        binding.horizontalScroll.setVisibility(View.VISIBLE);
        binding.location.setVisibility(View.VISIBLE);
        binding.arrowDown.setVisibility(View.VISIBLE);
        binding.arrowTop.setVisibility(View.VISIBLE);
    }

    private void onError(Throwable throwable) {
        binding.description.setText(throwable.getMessage());
    }
}
