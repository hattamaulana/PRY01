package ac.id.polinema.delaundry.ui.transactions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executors;

import ac.id.polinema.delaundry.database.PriceDao;
import ac.id.polinema.delaundry.helper.DbHelper;
import ac.id.polinema.delaundry.model.PriceModel;

public class TransactionsViewModel extends AndroidViewModel {

    public MutableLiveData<List<PriceModel>> prices;
    private PriceDao priceDao;

    public TransactionsViewModel(@NonNull Application application) {
        super(application);
        priceDao = DbHelper.instance(application.getApplicationContext()).priceDao();
    }

    public void loadPrices() {
        Executors.newSingleThreadExecutor().submit(() -> {
            List<PriceModel> _prices = priceDao.getAll();
            prices.postValue(_prices);
        });
    }
}