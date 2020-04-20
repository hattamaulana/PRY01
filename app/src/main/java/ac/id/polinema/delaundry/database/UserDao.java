package ac.id.polinema.delaundry.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import ac.id.polinema.delaundry.model.UserModel;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    UserModel get();

    @Insert
    void save(UserModel userModel);

    @Query("DELETE FROM user")
    void remove();
}
