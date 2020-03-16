package ac.id.polinema.delaundry.repository;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ac.id.polinema.delaundry.App;
import ac.id.polinema.delaundry.api.ApiService;
import ac.id.polinema.delaundry.database.AppDatabase;
import ac.id.polinema.delaundry.database.PriceDao;
import ac.id.polinema.delaundry.helper.ApiHelper;
import ac.id.polinema.delaundry.helper.DbHelper;
import ac.id.polinema.delaundry.model.PriceModel;

public class Repository {

    private Context context;
    private ApiService api;
    private AppDatabase database;

    private MutableLiveData<List<PriceModel>> livePrices;

    public Repository(Context context) {
        this.context = context;
        api = ApiHelper.getInstance();
        database = DbHelper.instance(context);
    }

    public LiveData<List<PriceModel>> loadPrices(boolean update) {
        PriceDao dao = database.priceDao();

        if (isConnected()) {
            api.getPrices().enqueue(new ApiHelper.EnQueue<>((response) -> {
                App.setSharedPreferences(App.IS_FIRST_TIME_LAUNCH, false);
                // Saving data price from web service to room
                List<PriceModel> prices = (List<PriceModel>) response.getData();
                for (PriceModel price: prices) {
                    dao.insert(price);
                }
            }));
        } else {
            if (update) {
                showMessage("Please Check Internet Connection.");
                return null;
            } else {
                livePrices.postValue(dao.getAll());
            }
        }

        return livePrices;
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }

        return false;
    }

    private void showMessage(String message) {
        View view = ((Activity) context).findViewById(android.R.id.content);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .show();
    }

}
