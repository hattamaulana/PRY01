package ac.id.polinema.delaundry.ui.histroy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import ac.id.polinema.delaundry.R;
import ac.id.polinema.delaundry.model.TransactionModel;
import ac.id.polinema.delaundry.ui.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryFragment extends Fragment
        implements RecyclerViewAdapter.Bind<TransactionModel> {

    @BindView(R.id.rv_history) RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter<>(
                R.layout.item_history, null, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void bind(BaseViewHolder holder, TransactionModel model) {
        holder
                .setText(R.id.tv_tipe, model.getCreatedAt())
                .setText(R.id.tv_price, model.getUpdatedAt());

        int color = (model.getStatusPayment() == 0) ?
                R.color.backgroundDone : R.color.backgroundDone;
        TextView tvStatus = holder.itemView.findViewById(R.id.tv_class);
        tvStatus.setBackgroundColor(requireContext().getResources().getColor(color));
    }
}
