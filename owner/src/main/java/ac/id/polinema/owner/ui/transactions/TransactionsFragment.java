package ac.id.polinema.owner.ui.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import ac.id.polinema.owner.R;
import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.ui.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TransactionsFragment extends Fragment implements
        RecyclerViewAdapter.Bind<TransactionModel> {

    private TransactionsViewModel viewModel;
    private RecyclerViewAdapter<TransactionModel> adapter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(TransactionsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new RecyclerViewAdapter<>(R.layout.item_transaction, null, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.observeDataOrder(getViewLifecycleOwner(), transactions ->
                adapter.setNewData(transactions)
        );
    }

    @Override
    public void bind(BaseViewHolder holder, TransactionModel o) {
        holder.setText(R.id.tv_nota, o.getNoNota())
              .setText(R.id.tv_tipe, o.getUser().getName());
    }
}
