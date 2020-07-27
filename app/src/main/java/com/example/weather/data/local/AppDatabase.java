package com.example.weather.data.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.data.local.dao.CityDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CityEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CityDao cityDao();

    private static volatile AppDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 3;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

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
        return Room.databaseBuilder(context, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .addCallback(roomDatabaseCallback)
                .build();
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            databaseWriteExecutor.execute(() -> {
                CityDao cityDao = INSTANCE.cityDao();
                if (cityDao.getCity().isEmpty()) {
                    CityEntity cityEntity = new CityEntity("Пермь");
                    cityDao.insertCity(cityEntity);
                    CityEntity city = new CityEntity("Москва");
                    cityDao.insertCity(city);
                }
            });
        }
    };
}
