package ac.id.polinema.delaundry.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ac.id.polinema.delaundry.model.PriceModel;

@Database(entities = PriceModel.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PriceDao priceDao();

}
