package ac.id.polinema.delaundry.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executors;

import ac.id.polinema.delaundry.App;
import ac.id.polinema.delaundry.api.ApiService;
import ac.id.polinema.delaundry.api.BodyRequest;
import ac.id.polinema.delaundry.database.AppDatabase;
import ac.id.polinema.delaundry.database.PriceDao;
import ac.id.polinema.delaundry.helper.ApiHelper;
import ac.id.polinema.delaundry.helper.DbHelper;
import ac.id.polinema.delaundry.model.TransactionModel;

import static ac.id.polinema.delaundry.repository.Utils.isConnected;

public class TransactionRepository {

    private static String TAG = TransactionRepository.class.getSimpleName();

    private Context context;
    private ApiService api;
    private AppDatabase database;

    public TransactionRepository(Context context) {
        this.context = context;
        api = ApiHelper.getInstance();
        database = DbHelper.instance(context);
    }

    public MutableLiveData<Boolean> order(List<String> types) {
        PriceDao dao = database.priceDao();
        BodyRequest.Order order = new BodyRequest.Order();
        MutableLiveData<Boolean> liveStatus = new MutableLiveData<>();

        if (isConnected(context)) {
            Executors.newSingleThreadExecutor().submit(() -> {
                List<Integer> ids = dao.getIdBytype(types);
                order.setIdUser(App.getIdUser());
                order.setIdPrices(ids);
                api.createTransaction(order)
                   .enqueue(new ApiHelper.EnQueue<>(response -> {
                       Log.d("TAG", "order: "+ response.getData().toString());
                       liveStatus.postValue(true);
                }));
            });
        } else {
            liveStatus.postValue(false);
        }

        return liveStatus;
    }

    public LiveData<List<TransactionModel>> getActiveTransactions() {
        MutableLiveData<List<TransactionModel>> liveData = new MutableLiveData<>();

        api.getTransactions(App.getIdUser())
           .enqueue(new ApiHelper.EnQueue<>(response -> {
               List<TransactionModel> transactionList = (List<TransactionModel>) response.getData();
               // TODO : Caching ke dalam database local

               liveData.postValue(transactionList);
        }));

        return liveData;
    }
}