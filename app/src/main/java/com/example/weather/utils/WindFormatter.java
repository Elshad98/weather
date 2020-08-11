package com.example.weather.utils;

public class WindFormatter {

    public static String format(float wind) {
        return String.valueOf("N " + Math.round(wind) + " mph");
    }

}
