package com.example.weather;

import android.app.Application;
import android.content.Context;

import com.example.weather.di.AppModule;

import toothpick.Scope;
import toothpick.Toothpick;

public class App extends Application {

    private static App instance;
    private Scope appScope;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        openAppScope();
    }

    private void openAppScope() {
        appScope = Toothpick.openScope(this);
        appScope.installModules(
                new AppModule()
        );
    }

    public static App instance() {
        return instance;
    }

    public static Scope scope() {
        return instance.appScope;
    }
}
