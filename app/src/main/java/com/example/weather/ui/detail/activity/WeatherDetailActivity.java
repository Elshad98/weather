package com.example.weather.ui.detail.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.weather.R;
import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.databinding.DetailActivityBinding;
import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;
import com.example.weather.utils.Constants;
import com.example.weather.utils.Formatter;
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
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(CurrentWeather currentWeather) {
        CurrentWeather.Weather weather = currentWeather.getWeather().get(0);
        Picasso.get().load(weather.getIcon()).into(binding.icon);
        binding.cityName.setText(currentWeather.getName());
        binding.tempMax.setText(Formatter.temperatureFormat(currentWeather.getMain().getTempMax()));
        binding.tempMin.setText(Formatter.temperatureFormat(currentWeather.getMain().getTempMin()));
        binding.temp.setText(Formatter.temperatureFormat(currentWeather.getMain().getTemp()));
        binding.description.setText(weather.getDescription());
        binding.feelsLike.setText(Formatter.temperatureFormat(currentWeather.getMain().getFeelsLike()));
        binding.humidity.setText(Formatter.humidityFormat(currentWeather.getMain().getHumidity()));
        binding.wind.setText(Formatter.windFormat(currentWeather.getWind().getSpeed()));
        binding.pressure.setText(Formatter.pressureFormat(currentWeather.getMain().getPressure()));
        binding.visibility.setText(Formatter.visibilityFormat(currentWeather.getVisibility()));
        binding.horizontalScroll.setVisibility(View.VISIBLE);
        binding.arrowDown.setVisibility(View.VISIBLE);
        binding.arrowTop.setVisibility(View.VISIBLE);
    }

    private void onError(Throwable throwable) {
        binding.description.setText(throwable.getMessage());
    }
}
