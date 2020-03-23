package ac.id.polinema.delaundry.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ac.id.polinema.delaundry.model.PriceModel;
import ac.id.polinema.delaundry.repository.PriceRepository;

public class HomeViewModel extends AndroidViewModel {

    private PriceRepository priceRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);

        priceRepository = new PriceRepository(application.getApplicationContext());
    }

    public LiveData<List<PriceModel>> getPrices() {
        return priceRepository.loadPrices(false);
    }
}