package com.example.weather.utils;

public class VisibilityFormatter {

    public static String format(int visibility) {
        return String.valueOf((double) (visibility / 1000) + " km");
    }

}
