package ac.id.polinema.owner.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import ac.id.polinema.owner.model.UserModel;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE id_user = :id")
    UserModel get(String id);

    @Insert
    void save(UserModel userModel);

    @Query("DELETE FROM users")
    void remove();
}
