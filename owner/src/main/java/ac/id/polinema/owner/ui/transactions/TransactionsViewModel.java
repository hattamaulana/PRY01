package ac.id.polinema.owner.ui.transactions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.List;

import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.repository.TransactionRepository;

public class TransactionsViewModel extends AndroidViewModel {

    private TransactionRepository transactionRepository;

    public TransactionsViewModel(@NonNull Application application) {
        super(application);
        transactionRepository = new TransactionRepository(application);
    }

    public void observeDataOrder(LifecycleOwner owner,
                                 Observer<List<TransactionModel>> observer) {
        transactionRepository.getOnProggress().observe(owner, observer);
    }
}