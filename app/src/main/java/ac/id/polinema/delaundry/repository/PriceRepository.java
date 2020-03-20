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
import java.util.concurrent.Executors;

import ac.id.polinema.delaundry.App;
import ac.id.polinema.delaundry.api.ApiService;
import ac.id.polinema.delaundry.database.AppDatabase;
import ac.id.polinema.delaundry.database.PriceDao;
import ac.id.polinema.delaundry.helper.ApiHelper;
import ac.id.polinema.delaundry.helper.DbHelper;
import ac.id.polinema.delaundry.model.PriceModel;

import static ac.id.polinema.delaundry.repository.Utils.isConnected;
import static ac.id.polinema.delaundry.repository.Utils.showMessage;

public class PriceRepository {

    private Context context;
    private ApiService api;
    private AppDatabase database;

    private MutableLiveData<List<PriceModel>> livePrices;

    public PriceRepository(Context context) {
        this.context = context;
        api = ApiHelper.getInstance();
        database = DbHelper.instance(context);

        livePrices = new MutableLiveData<>();
    }

    public LiveData<List<PriceModel>> loadPrices(boolean update) {
        PriceDao dao = database.priceDao();

        if (isConnected(context)) {
            api.getPrices().enqueue(new ApiHelper.EnQueue<>((response) -> {
                App.setSharedPreferences(App.IS_FIRST_TIME_LAUNCH, false);
                // Saving data price from web service to room
                List<PriceModel> prices = (List<PriceModel>) response.getData();
                for (PriceModel price: prices) {
                    Executors.newSingleThreadExecutor().submit(() -> dao.insert(price));
                }
            }));
        } else {
            if (update) {
                showMessage(context, "Please Check Internet Connection.");
                return null;
            } else {
                livePrices.postValue(dao.getAll());
            }
        }

        return livePrices;
    }

}
