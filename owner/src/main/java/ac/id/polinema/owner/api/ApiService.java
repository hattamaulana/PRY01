package ac.id.polinema.owner.api;

import ac.id.polinema.owner.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("/user/login/admin")
    Call<Response<UserModel>> login(@Field("no_handphone") String no_handphone,
                                    @Field("password") String password);

}
