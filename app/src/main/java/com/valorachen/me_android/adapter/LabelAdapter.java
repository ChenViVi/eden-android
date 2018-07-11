package com.valorachen.me_android.adapter;

import android.app.Activity;
import android.graphics.Color;

import com.chenyuwei.basematerial.adapter.BaseAdapter;
import com.chenyuwei.basematerial.adapter.BaseViewHolder;
import com.valorachen.me_android.R;
import com.valorachen.me_android.model.Issue;
import com.valorachen.me_android.model.Label;

import java.util.List;

/**
 * Created by vivi on 2016/8/10.
 */
public class LabelAdapter extends BaseAdapter<Label> {


    public LabelAdapter(Activity activity, List<Label> data) {
        super(activity, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Label item, int position) {
        holder.setText(R.id.tvLabel, item.getName());
        holder.setCardBackgroundColor(R.id.cvLabel, Color.parseColor("#" + item.getColor()));
    }

    @Override
    protected int getItemViewLayoutId(int viewType) {
        return R.layout.item_label;
    }
}