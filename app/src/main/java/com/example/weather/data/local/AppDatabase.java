package com.example.weather.data.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.weather.data.local.dao.CityDao;
import com.example.weather.data.local.entity.CityEntity;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

@Database(entities = {CityEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CityDao cityDao();

    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "city_database";

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .addCallback(roomDatabaseCallback)
                .build();
    }

    private static final RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Completable.fromAction(() -> {
                CityDao cityDao = INSTANCE.cityDao();
                if (cityDao.getCity().isEmpty()) {
                    CityEntity cityEntity = new CityEntity("Perm");
                    cityDao.insertCity(cityEntity);
                }
            }).subscribeOn(Schedulers.io())
                    .subscribe();
        }
    };
}
