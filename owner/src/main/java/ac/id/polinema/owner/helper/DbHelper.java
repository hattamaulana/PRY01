package ac.id.polinema.owner.helper;

import android.content.Context;

import androidx.room.Room;

import ac.id.polinema.owner.database.AppDatabase;

public class DbHelper {

    private static AppDatabase instance;

    private DbHelper() {
    }

    public static AppDatabase instance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "app_database.db")
                    .build();
        }

        return instance;
    }
}
