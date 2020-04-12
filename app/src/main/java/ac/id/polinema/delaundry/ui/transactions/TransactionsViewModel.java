package ac.id.polinema.delaundry.ui.transactions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ac.id.polinema.delaundry.model.PriceModel;
import ac.id.polinema.delaundry.model.TransactionModel;
import ac.id.polinema.delaundry.repository.PriceRepository;
import ac.id.polinema.delaundry.repository.TransactionRepository;

public class TransactionsViewModel extends AndroidViewModel {

    private TransactionRepository repository;
    private PriceRepository priceRepository;

    public TransactionsViewModel(@NonNull Application application) {
        super(application);
        repository = new TransactionRepository(application);
        priceRepository = new PriceRepository(application);
    }

    public LiveData<List<PriceModel>> fetchDataPrices() {
        return priceRepository.loadPrices(false);
    }

    public LiveData<List<TransactionModel>> getActive() {
        return repository.getActiveTransactions();
    }
}