package ac.id.polinema.delaundry.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ac.id.polinema.delaundry.App;
import ac.id.polinema.delaundry.R;
import ac.id.polinema.delaundry.repository.PriceRepository;

import static androidx.navigation.Navigation.findNavController;

public class SplashFragment extends Fragment {

    private Runnable runAsync = () -> {
        if (App.isFirstTimeLaunch()) {
            PriceRepository repo = new PriceRepository(getContext());
            repo.loadPrices(true);
        }

        if (!App.isFirstTimeLaunch()) {
            findNavController(getView()).navigate(R.id.toRegisterFragment);
        } else if (!App.isLogIn()) {
            findNavController(getView()).navigate(R.id.splashToHome);
        } else {
            findNavController(getView()).navigate(R.id.toLoginFragment);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new Handler().postDelayed(runAsync, 3000);
        getView();
    }
}
