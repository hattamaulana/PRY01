package ac.id.polinema.delaundry;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import ac.id.polinema.delaundry.repository.Repository;

public class MainActivity extends AppCompatActivity {

    private Runnable runAsync = () -> {
        Class cls;

        if (App.isFirstTimeLaunch()) {
            Repository repo = new Repository(getApplicationContext());
            repo.loadPrices(true);
        }

        if (App.isLogIn()) {
            cls = LoginActivity.class;
        } else {
            cls = HomeActivity.class;
        }

        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
        finish();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarTransparent();

        new Handler().post(runAsync);
    }

    private void setStatusBarTransparent() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }
}
