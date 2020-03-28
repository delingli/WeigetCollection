package com.ldl.myapplication;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class MainRecycleAdapter extends BaseRecyclerAdapter<MainItem> {
    /**
     * @param context
     * @param list
     * @param itemLayoutId
     */
    public MainRecycleAdapter(Context context, @Nullable List<MainItem> list, int itemLayoutId) {
        super(context, list, R.layout.main_recycle_item);
    }

    @Override
    protected void convert(BaseViewHolder holder, MainItem mainItem, int position, List<Object> payloads) {
        if (null != mainItem) {
            TextView textView = holder.getView(R.id.tv_title);
            textView.setText(mainItem.title);

        }
    }
}
