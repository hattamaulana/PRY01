package ac.id.polinema.owner.ui.account;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ac.id.polinema.owner.model.PriceModel;
import ac.id.polinema.owner.repository.PriceRepository;

public class AccountViewModel extends AndroidViewModel {

    private PriceRepository priceRepository;

    LiveData<List<PriceModel>> liveData;

    public AccountViewModel(@NonNull Application application) {
        super(application);
        priceRepository = new PriceRepository(application);
        liveData = new MutableLiveData<>();
        liveData = priceRepository.getPrice();
    }

    void save(PriceModel price) {
        priceRepository.save(price, () -> {

        });
    }

    void update(PriceModel price) {
        priceRepository.update(price, () -> {

        });
    }
}
