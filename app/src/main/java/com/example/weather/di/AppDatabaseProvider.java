package com.example.weather.di;

import android.content.Context;

import com.example.weather.data.local.AppDatabase;

import javax.inject.Inject;
import javax.inject.Provider;

public class AppDatabaseProvider implements Provider<AppDatabase> {

    private final Context context;

    @Inject
    public AppDatabaseProvider(Context context) {
        this.context = context;
    }

    @Override
    public AppDatabase get() {
        return AppDatabase.getInstance(context);
    }
}
