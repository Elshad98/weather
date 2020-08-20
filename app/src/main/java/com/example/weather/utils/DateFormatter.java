package com.example.weather.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    public static String formatDate(long dt) {
        Date date = new Date(dt * 1000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy", Locale.US);
        return dateFormat.format(date).toLowerCase();
    }

}
