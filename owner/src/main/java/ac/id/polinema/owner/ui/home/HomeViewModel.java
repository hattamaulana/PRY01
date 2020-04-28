package ac.id.polinema.owner.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.repository.TransactionRepository;

public class HomeViewModel extends AndroidViewModel {

    private TransactionRepository transactionRepository;

    MutableLiveData<List<TransactionModel>> liveData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        liveData = new MutableLiveData<>();
        transactionRepository = new TransactionRepository(application);
        liveData = transactionRepository.getNewOrder();
    }

    void changeStatus(String noNota) {
        final String ON_PROGGRESS = "ON PROGGRESS";
        transactionRepository.changeStatus(noNota, ON_PROGGRESS, () -> {
            liveData = transactionRepository.getNewOrder();
        });
    }
}