package ac.id.polinema.owner.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import ac.id.polinema.owner.App;
import ac.id.polinema.owner.helper.ApiHelper;
import ac.id.polinema.owner.model.UserModel;

import static ac.id.polinema.owner.helper.Helper.showMessage;

public class UserRepository extends Repository {

    private MutableLiveData<Boolean> liveResult;

    public UserRepository(Context context) {
        super(context);
        liveResult = new MutableLiveData<>();
    }

    public LiveData<Boolean> login(String noHandphone, String password) {
        if (isOnline()) {
            service.login(noHandphone, password).enqueue(new ApiHelper.EnQueue<>((response) -> {
                UserModel user = (UserModel) response.getData();
                App.setSharedPreferences(App.NO_HANDPHONE, user.getNoHandphone());
                App.setSharedPreferences(App.KEY_ID_USER, user.getIdUser());
                Log.d("TAG", "createAccount: "+ user.getIdUser());

                boolean isSuccess = response.getStatus() == 200;
                liveResult.postValue(isSuccess);
                if (!isSuccess) {
                    showMessage(context, response.getMessage());
                }
            }));
        }

        return liveResult;
    }
}
