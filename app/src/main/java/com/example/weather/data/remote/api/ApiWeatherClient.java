package com.example.weather.data.remote.api;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiWeatherClient {

    private static final long TIMEOUT = 60;

    @Inject
    public ApiWeatherClient() {
    }

    private static final String API_KEY = "6cbf06dd7b501ba9387c6a99a826aae6";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String IMAGE_URL = "http://openweathermap.org/img/wn/%s@4x.png";

    public ApiWeather getClient() {
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
                .create(ApiWeather.class);
    }
}
