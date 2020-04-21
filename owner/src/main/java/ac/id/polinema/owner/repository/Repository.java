package ac.id.polinema.owner.repository;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ac.id.polinema.owner.api.ApiService;
import ac.id.polinema.owner.helper.ApiHelper;

import static ac.id.polinema.owner.helper.Helper.isConnected;
import static ac.id.polinema.owner.helper.Helper.showMessage;

public class Repository {

    protected Context context;
    protected ApiService service;
    protected ExecutorService executorService;

    protected Repository(Context context) {
        this.context = context;
        this.service = ApiHelper.getInstance();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    protected boolean isOnline() {
        if (!isConnected(context)) {
            showMessage(context,"Please Check Internet Connection.");
            return false;
        } else {
            return true;
        }
    }
}
