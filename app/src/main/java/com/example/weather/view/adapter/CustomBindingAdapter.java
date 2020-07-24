package com.example.weather.view.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {

    private static final String ICON_URL = "http://openweathermap.org/img/wn/ICON_CODE@4x.png";

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String icon) {
        if (icon == null) {
            view.setImageURI(null);
        } else {
            String url = ICON_URL.replace("ICON_CODE", icon);
            Picasso.get().load(url).into(view);
        }
    }

}
