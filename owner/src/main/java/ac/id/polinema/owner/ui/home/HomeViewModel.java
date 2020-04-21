package ac.id.polinema.owner.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.repository.TransactionRepository;

public class HomeViewModel extends AndroidViewModel {

    TransactionRepository transactionRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        transactionRepository = new TransactionRepository(application);
    }

    public LiveData<List<TransactionModel>> observeNewOrder() {
        return transactionRepository.getNewOrder();
    }
}