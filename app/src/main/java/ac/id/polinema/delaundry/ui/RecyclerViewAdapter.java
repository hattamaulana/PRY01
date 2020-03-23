package ac.id.polinema.delaundry.ui;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class RecyclerViewAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    private Bind<T> binding;

    public interface Bind<T> {
        void bind(BaseViewHolder holder, T t);
    }

    public RecyclerViewAdapter(int layoutResId, List<T> data, Bind<T> bindView) {
        super(layoutResId, data);
        this.binding = bindView;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, T t) {
        binding.bind(baseViewHolder, t);
    }
}
