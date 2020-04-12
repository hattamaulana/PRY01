package ac.id.polinema.delaundry.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import ac.id.polinema.delaundry.App;
import ac.id.polinema.delaundry.api.ApiService;
import ac.id.polinema.delaundry.helper.ApiHelper;
import ac.id.polinema.delaundry.model.UserModel;

import static ac.id.polinema.delaundry.repository.Utils.isConnected;
import static ac.id.polinema.delaundry.repository.Utils.showMessage;

public class UserRepository {

    private Context context;
    private ApiService service;
    private MutableLiveData<Boolean> liveResult;

    public UserRepository(Context context) {
        this.context = context;
        this.service = ApiHelper.getInstance();

        liveResult = new MutableLiveData<>();
    }

    public LiveData<Boolean> register(String noHandphone) {
        if (isConnected(context)) {
            service.register(noHandphone).enqueue(new ApiHelper.EnQueue<>((response) -> {
                boolean isSuccess = response.getStatus() == 200;
                liveResult.postValue(isSuccess);
                if (!isSuccess) {
                    showMessage(context, response.getMessage());
                }
            }));
        } else {
            showMessage(context,"Please Check Internet Connection.");
        }

        return liveResult;
    }

    public LiveData<Boolean> createAccount(UserModel model) {
        if (isConnected(context)) {
            service.createAccount(model).enqueue(new ApiHelper.EnQueue<>((response) -> {
                UserModel user = (UserModel) response.getData();
                App.setSharedPreferences(App.IS_FIRST_TIME_LAUNCH, false);
                App.setSharedPreferences(App.NO_HANDPHONE, user.getNoHandphone());
                App.setSharedPreferences(App.KEY_ID_USER, user.getIdUser());
                Log.d("TAG", "createAccount: "+ user.getIdUser());

                boolean isSuccess = response.getStatus() == 200;
                liveResult.postValue(isSuccess);
                if (!isSuccess) {
                    showMessage(context, response.getMessage());
                }
            }));
        } else {
            showMessage(context,"Please Check Internet Connection.");
        }

        return liveResult;
    }

    public LiveData<Boolean> login(String noHandphone, String password) {
        if (isConnected(context)) {
            service.login(noHandphone, password).enqueue(new ApiHelper.EnQueue<>((response) -> {
                UserModel user = (UserModel) response.getData();
                App.setSharedPreferences(App.IS_FIRST_TIME_LAUNCH, false);
                App.setSharedPreferences(App.NO_HANDPHONE, user.getNoHandphone());
                App.setSharedPreferences(App.KEY_ID_USER, user.getIdUser());
                Log.d("TAG", "createAccount: "+ user.getIdUser());

                boolean isSuccess = response.getStatus() == 200;
                liveResult.postValue(isSuccess);
                if (!isSuccess) {
                    showMessage(context, response.getMessage());
                }
            }));
        } else {
            showMessage(context,"Please Check Internet Connection.");
        }

        return liveResult;
    }
}
