package com.example.weather.di.component;

import android.app.Application;

import com.example.weather.App;
import com.example.weather.di.module.ActivityModule;
import com.example.weather.di.module.ApiModule;
import com.example.weather.di.module.DbModule;
import com.example.weather.di.module.FragmentModule;
import com.example.weather.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApiModule.class, DbModule.class, ViewModelModule.class,
        AndroidSupportInjectionModule.class, ActivityModule.class, FragmentModule.class})
public interface ApiComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder apiModule(ApiModule apiModule);

        @BindsInstance
        Builder dbModule(DbModule dbModule);

        ApiComponent build();
    }

    void inject(App app);
}
