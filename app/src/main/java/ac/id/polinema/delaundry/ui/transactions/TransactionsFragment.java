package ac.id.polinema.delaundry.ui.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import ac.id.polinema.delaundry.R;
import ac.id.polinema.delaundry.model.PriceModel;
import ac.id.polinema.delaundry.model.TransactionDetailModel;
import ac.id.polinema.delaundry.ui.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TransactionsFragment extends Fragment
        implements RecyclerViewAdapter.Bind<TransactionDetailModel> {

    private TransactionsViewModel viewModel;

    @BindView(R.id.rv_transaction) RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(TransactionsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter<>(
                R.layout.item_price, null, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void bind(BaseViewHolder holder, TransactionDetailModel model) {
        holder
                .setText(R.id.tv_price, model.getBobot() + " Kg")
                .setText(R.id.tv_class, model.getStatusString());

        int color;
        if (model.getStatus() == 0) {
            color = getContext().getResources().getColor(R.color.backgroundProggress);
        } else {
            color = getContext().getResources().getColor(R.color.backgroundDone);
        }

        TextView tvStatus = holder.itemView.findViewById(R.id.tv_class);
        tvStatus.setBackgroundColor(color);

        viewModel.prices.observe(getViewLifecycleOwner(), prices -> {
            for (PriceModel price : prices) {
                if (price.getIdHarga() == model.getIdHarga()) {
                    holder.setText(R.id.tv_tipe, price.getKelas() + " / " + price.getType());
                }
            }
        });
    }
}
