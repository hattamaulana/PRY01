package ac.id.polinema.delaundry.api;

import java.util.List;

import ac.id.polinema.delaundry.model.TransactionModel;
import ac.id.polinema.delaundry.model.UserModel;
import ac.id.polinema.delaundry.model.PriceModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("/user/register")
    Call<Response<Boolean>> register(@Field("no_handphone") String no_handphone);

    @POST("/user/register/account")
    Call<Response<UserModel>> createAccount(@Body UserModel userModel);

    @FormUrlEncoded
    @POST("/user/login")
    Call<Response<Boolean>> login(@Field("no_handphone") String no_handphone,
                                  @Field("password") String password);

    @POST("/order")
    Call<Response<TransactionModel>> createTransaction(@Body TransactionModel transactionModel);

    @GET("/status")
    Call<Response<TransactionModel>> getStatus();

    @GET("/prices")
    Call<Response<List<PriceModel>>> getPrices();

}
