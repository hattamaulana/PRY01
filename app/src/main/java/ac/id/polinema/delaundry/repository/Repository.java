package ac.id.polinema.delaundry.repository;

import ac.id.polinema.delaundry.api.ApiService;
import ac.id.polinema.delaundry.helper.ApiHelper;

public class Repository {

    private ApiService api = ApiHelper.getInstance();

    public void loadPrices() {
        api.getPrices().enqueue(new ApiHelper.EnQueue<>((response) -> {
            // TODO : Saving data price from web service to room
        }));
    }

}
