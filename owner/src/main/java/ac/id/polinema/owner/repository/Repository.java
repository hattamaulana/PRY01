package ac.id.polinema.owner.repository;

import android.content.Context;

import ac.id.polinema.owner.api.ApiService;
import ac.id.polinema.owner.helper.ApiHelper;

import static ac.id.polinema.owner.helper.Helper.isConnected;
import static ac.id.polinema.owner.helper.Helper.showMessage;

public class Repository {

    protected Context context;
    protected ApiService service;

    protected Repository(Context context) {
        this.context = context;
        this.service = ApiHelper.getInstance();
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
