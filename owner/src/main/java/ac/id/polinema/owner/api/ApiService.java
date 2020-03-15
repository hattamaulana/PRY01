package ac.id.polinema.owner.api;

import java.util.List;

import ac.id.polinema.owner.model.PriceModel;
import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/user/register")
    Call<Response<Boolean>> register(@Field("no_handphone") String no_handphone);

    @POST("/user/register/account")
    Call<Response<UserModel>> createAccount(@Body UserModel userModel);

    @POST("/user/register")
    Call<Response<Boolean>> login(@Field("no_handphone") String no_handphone,
                                  @Field("password") String password);

    @POST("/order")
    Call<Response<TransactionModel>> createTransaction(@Body TransactionModel transactionModel);

    @GET("/status")
    Call<Response<TransactionModel>> getStatus();

    @GET("/prices")
    Call<Response<List<PriceModel>>> getPrices();

}
