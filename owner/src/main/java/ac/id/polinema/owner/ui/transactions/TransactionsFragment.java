package ac.id.polinema.owner.ui.transactions;

import android.os.Bundle;
import android.view.LayoutInflater;
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

import ac.id.polinema.owner.R;
import ac.id.polinema.owner.model.TransactionDetailModel;
import ac.id.polinema.owner.model.TransactionModel;
import ac.id.polinema.owner.ui.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

import static ac.id.polinema.owner.Utils.setActionBarTitleAndSub;
import static androidx.navigation.Navigation.findNavController;

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
        setActionBarTitleAndSub(getActivity(), "Transaksi", "");
        adapter = new RecyclerViewAdapter<>(R.layout.item_transaction, null, this);
        adapter.setOnItemClickListener((_adapter, view, position) -> {
            TransactionModel transaction = adapter.getData().get(position);
            String transactionBy = transaction.getUser().getName();
            TransactionDetailModel[] data = transaction.getTransactionsArray();
            NavDirections direction = TransactionsFragmentDirections
                    .homeToDetailTransaction(data, transactionBy, transaction.getCreatedAt());
            findNavController(getView()).navigate(direction);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.observeDataOrder(getViewLifecycleOwner(), transactions ->
                adapter.setNewData(transactions)
        );
    }

    @Override
    public void bind(BaseViewHolder holder, TransactionModel model) {
        holder.setText(R.id.tv_nota, model.getNoNota())
              .setText(R.id.tv_tipe, model.getUser().getName());
        boolean isDone = true;
        for (TransactionDetailModel _model: model.getTransactions()) {
            if (!_model.isStatus()) {
                isDone = false;
                break;
            }
        }
        holder.setVisible(R.id.iv_checked, isDone);
    }
}
