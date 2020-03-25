package ac.id.polinema.delaundry.repository;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ac.id.polinema.delaundry.helper.ApiHelper;

public class Utils {

    private static String TAG = Utils.class.getSimpleName();

    public static boolean isConnected(Context context) {
        try {
            Future<Boolean> newThread =  Executors.newSingleThreadExecutor().submit(() -> {
                ConnectivityManager connectivityManager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                URL myUrl = new URL(ApiHelper.URL);

                connectivityManager.getActiveNetworkInfo();
                URLConnection connection = myUrl.openConnection();
                connection.setConnectTimeout(3000);
                connection.connect();
                Log.i(TAG, "isConnected: status=TRUE");
                return true;
            });

            return newThread.get();
        } catch (ExecutionException | InterruptedException | NullPointerException e) {
            Log.i(TAG, "isConnected: status=FALSE");
            return false;
        }
    }

    public static void showMessage(Context context, String message) {
        View view = ((Activity) context).findViewById(android.R.id.content);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .show();
    }
}
