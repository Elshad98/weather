package com.example.weather.di;

import com.example.weather.data.remote.api.WeatherApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiServiceProvider implements Provider<WeatherApiService> {

    private static final long TIMEOUT = 60;
    private static final String API_KEY = "6cbf06dd7b501ba9387c6a99a826aae6";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    @Inject
    public WeatherApiServiceProvider() {
    }

    @Override
    public WeatherApiService get() {
        Interceptor requestInterceptor = chain -> {
            HttpUrl url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build();

            Request request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build();

            return chain.proceed(request);
        };

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService.class);
    }
}
