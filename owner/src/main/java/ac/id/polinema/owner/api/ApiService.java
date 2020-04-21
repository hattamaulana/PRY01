package ac.id.polinema.owner.api;

import java.util.List;

import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("/admin/login")
    Call<Response<UserModel>> login(@Field("no_handphone") String no_handphone,
                                    @Field("password") String password);

    @GET("/admin/order/new")
    Call<Response<List<TransactionModel>>> getNewOrder();

}
