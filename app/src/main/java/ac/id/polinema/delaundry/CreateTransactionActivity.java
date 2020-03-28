package ac.id.polinema.delaundry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ac.id.polinema.delaundry.model.PriceList;
import ac.id.polinema.delaundry.model.PriceModel;
import ac.id.polinema.delaundry.repository.PriceRepository;
import ac.id.polinema.delaundry.repository.TransactionRepository;
import ac.id.polinema.delaundry.ui.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static ac.id.polinema.delaundry.repository.Utils.showMessage;

public class CreateTransactionActivity extends AppCompatActivity implements
        RecyclerViewAdapter.Bind<PriceList> {

    private static String TAG = CreateTransactionActivity.class.getSimpleName();

    private RecyclerViewAdapter<PriceList> adapter;
    private List<String> type;

    @BindView(R.id.rv_transaction) RecyclerView recyclerView;

    @OnClick(R.id.btn_order) void order() {
        TransactionRepository repository = new TransactionRepository(this);
        repository.order(type).observe(this, result -> {
            if (result) {
                String message = "Order Success";
                showMessage(CreateTransactionActivity.this, message);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_transaction);
        ButterKnife.bind(this);
        getPrices();

        type = new ArrayList<>();
        adapter = new RecyclerViewAdapter<>(R.layout.item_order, null, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void bind(BaseViewHolder holder, PriceList priceList) {
        ChipGroup chipGroup = holder.findView(R.id.cg_type);
        holder.setText(R.id.tv_class, priceList.getKelas());

        for (PriceModel price: priceList.getPriceModels()) {
            Chip chip = (Chip) getLayoutInflater().inflate(R.layout.layout_chip,
                    chipGroup, false);
            chip.setText(price.getType());
            chip.setOnClickListener(click -> {
                String label = chip.getText().toString();
                if (chip.isChecked()) {
                    type.add(label);
                } else {
                    type.remove(label);
                }
            });

            chipGroup.addView(chip);
        }
    }

    private void getPrices() {
        PriceRepository priceRepository = new PriceRepository(this);
        priceRepository.loadPrices(false).observe(this, prices -> {
            Set<String> kelas = new HashSet<>();
            for (PriceModel price: prices) kelas.add(price.getKelas());

            List<PriceList> priceLists = new ArrayList<>();
            for (String s: kelas) {
                List<PriceModel> tmp = new ArrayList<>();
                for (PriceModel price: prices) {
                    if (price.getKelas().equals(s)) {
                        tmp.add(price);
                    }
                }

                priceLists.add(new PriceList(s, tmp));
            }

            adapter.setNewData(priceLists);
        });
    }
}
