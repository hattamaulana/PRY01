package ac.id.polinema.delaundry.helper;

import android.content.Context;

import androidx.room.Room;

import ac.id.polinema.delaundry.database.AppDatabase;

public class DbHelper {

    private static AppDatabase instance;

    public static AppDatabase instance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "app_database.db")
                    .build();
        }

        return instance;
    }
}
