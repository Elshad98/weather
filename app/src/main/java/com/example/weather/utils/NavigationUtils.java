package com.example.weather.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.ui.detail.activity.WeatherDetailActivity;

public class NavigationUtils {

    public static void redirectToDetailScreen(
            Activity activity,
            CityEntity city,
            ActivityOptionsCompat options) {
        Intent intent = new Intent(activity, WeatherDetailActivity.class);
        intent.putExtra(Constants.INTENT_CITY, (Parcelable) city);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
