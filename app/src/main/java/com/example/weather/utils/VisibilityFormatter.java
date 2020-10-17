package com.example.weather.utils;

public class VisibilityFormatter {

    public static String format(int visibility) {
        return (double) (visibility / 1000) + " km";
    }
}
