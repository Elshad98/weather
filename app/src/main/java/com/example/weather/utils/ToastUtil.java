package com.example.weather.utils;

import android.widget.Toast;

import com.example.weather.App;

public class ToastUtil {

    public static void showShort(String message) {
        Toast.makeText(App.instance(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String message) {
        Toast.makeText(App.instance(), message, Toast.LENGTH_LONG).show();
    }

    public static void showShort(int resId) {
        Toast.makeText(App.instance(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int resId) {
        Toast.makeText(App.instance(), resId, Toast.LENGTH_LONG).show();
    }
}