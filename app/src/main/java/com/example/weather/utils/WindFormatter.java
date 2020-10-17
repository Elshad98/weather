package com.example.weather.utils;

public class WindFormatter {

    public static String format(float wind) {
        return "N " + Math.round(wind) + " mph";
    }
}
