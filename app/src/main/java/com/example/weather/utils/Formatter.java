package com.example.weather.utils;

public class Formatter {

    public static String temperatureFormat(float temperature) {
        return String.valueOf(Math.round(temperature) + "°");
    }

    public static String humidityFormat(int humidity) {
        return String.valueOf(humidity + "%");
    }

    public static String windFormat(float wind) {
        return String.valueOf("N " + Math.round(wind) + " mph");
    }

    public static String pressureFormat(int pressure) {
        return String.valueOf(pressure + " hPa");
    }

    public static String visibilityFormat(int visibility) {
        return String.valueOf((double) (visibility / 1000) + " km");
    }

}
