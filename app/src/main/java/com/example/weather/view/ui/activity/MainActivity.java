package com.example.weather.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weather.R;
import com.example.weather.view.ui.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            WeatherFragment fragment = new WeatherFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, "WeatherFragment").commit();
        }
    }
}