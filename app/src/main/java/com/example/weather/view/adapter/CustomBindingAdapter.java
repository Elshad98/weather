package com.example.weather.view.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.weather.utils.Constants;
import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String icon) {
        if (icon == null) {
            view.setImageURI(null);
        } else {
            String url = String.format(Constants.IMAGE_URL, icon);
            Picasso.get().load(url).into(view);
        }
    }

}
