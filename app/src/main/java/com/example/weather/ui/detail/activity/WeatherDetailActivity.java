package com.example.weather.ui.detail.activity;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.weather.App;
import com.example.weather.R;
import com.example.weather.data.remote.model.CurrentWeather;
import com.example.weather.databinding.DetailActivityBinding;
import com.example.weather.ui.base.BaseActivity;
import com.example.weather.ui.detail.viewmodel.WeatherDetailViewModel;
import com.example.weather.ui.main.activity.MainActivity;
import com.example.weather.utils.DateFormatter;
import com.example.weather.utils.HumidityFormatter;
import com.example.weather.utils.PressureFormatter;
import com.example.weather.utils.TemperatureFormatter;
import com.example.weather.utils.VisibilityFormatter;
import com.example.weather.utils.WindFormatter;
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
        viewModel.getWeatherByCityName(cityName)
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
