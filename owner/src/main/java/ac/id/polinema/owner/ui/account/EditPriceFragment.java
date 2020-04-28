package ac.id.polinema.owner.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import ac.id.polinema.owner.R;
import ac.id.polinema.owner.model.PriceModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditPriceFragment extends Fragment implements Validator.ValidationListener {

    private EditPriceFragmentArgs args;
    private AccountViewModel viewModel;
    private Validator validator;

    @NotEmpty
    @BindView(R.id.edt_tipe)
    EditText edtTipe;

    @NotEmpty
    @BindView(R.id.edt_kelas)
    EditText edtKelas;

    @NotEmpty
    @BindView(R.id.edt_harga)
    EditText edtHarga;

    @OnClick(R.id.btn_save) void submit() {
        validator.validate();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = EditPriceFragmentArgs.fromBundle(getArguments());
        viewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_price, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (args.getData() != null) {
            fillData();
        }
    }

    private void fillData() {
        edtTipe.setText(args.getData().getType());
        edtKelas.setText(args.getData().getKelas());
        edtHarga.setText(String.valueOf(args.getData().getPrice()));
    }

    @Override
    public void onValidationSucceeded() {
        PriceModel priceModel = new PriceModel();
        priceModel.setType(edtTipe.getText().toString());
        priceModel.setKelas(edtKelas.getText().toString());
        priceModel.setIdHarga(Integer.parseInt(edtHarga.getText().toString()));
        if (args.getData() != null) {
            viewModel.save(priceModel);
        } else {
            viewModel.update(priceModel);
        }
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
