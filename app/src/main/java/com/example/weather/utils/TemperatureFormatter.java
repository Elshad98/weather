package com.example.weather.utils;

public class TemperatureFormatter {

    public static String format(float temperature) {
        return Math.round(temperature) + "°";
    }
}
