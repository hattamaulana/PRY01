package ac.id.polinema.owner.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

import ac.id.polinema.owner.App;
import ac.id.polinema.owner.MainActivity;
import ac.id.polinema.owner.R;
import ac.id.polinema.owner.model.PriceModel;
import ac.id.polinema.owner.ui.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static ac.id.polinema.owner.ui.account.AccountFragmentDirections.toEditPrice;
import static androidx.navigation.Navigation.findNavController;

public class AccountFragment extends Fragment implements RecyclerViewAdapter.Bind<PriceModel> {

    private final String TAG = AccountFragment.class.getSimpleName();

    RecyclerViewAdapter<PriceModel> adapter;
    AccountViewModel viewModel;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @OnClick(R.id.fab_add) void fabAdd() {
        findNavController(getView()).navigate(toEditPrice());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        viewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        ButterKnife.bind(this, rootView);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new RecyclerViewAdapter<>(R.layout.item_price, null, this);
        adapter.setOnItemChildClickListener((_adapter, view, position) -> {
            List<PriceModel> prices = _adapter.getData();
            PriceModel price = prices.get(position);
            if (view.getId() == R.id.iv_edit) {
                Log.i(TAG, "onActivityCreated: id="+ price.getIdHarga());
                NavDirections direction = toEditPrice().setData(price);
                findNavController(getView()).navigate(direction);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.liveData.observe(getViewLifecycleOwner(), prices -> adapter.setNewData(prices));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.account_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            App.setSharedPreferences(App.NO_HANDPHONE, "");
            startActivity(new Intent(getContext(), MainActivity.class));
            getActivity().finish();
        }

        return true;
    }

    @Override
    public void bind(BaseViewHolder holder, PriceModel priceModel) {
        Log.i(TAG, "bind: id="+ priceModel.getIdHarga());
        holder.setText(R.id.tv_tipe, priceModel.getType())
              .setText(R.id.tv_kelas, priceModel.getKelas())
              .setText(R.id.tv_price, priceModel.getPrice().toString());
    }
}
