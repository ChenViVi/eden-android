package com.valorachen.me_android.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chenyuwei.basematerial.adapter.BaseAdapter;
import com.chenyuwei.basematerial.adapter.BaseViewHolder;
import com.valorachen.me_android.R;
import com.valorachen.me_android.model.Issue;
import com.valorachen.me_android.model.Label;

import java.util.List;

/**
 * Created by vivi on 2016/8/10.
 */
public class ArticleAdapter extends BaseAdapter<Issue> {


    public ArticleAdapter(Activity activity, List<Issue> data) {
        super(activity, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Issue item, int position) {
        holder.setIsRecyclable(false);
        holder.setText(R.id.tvTitle, item.getTitle());
        for (Label label : item.getLabels()){
            CardView cvLabel = (CardView) LayoutInflater.from(activity).inflate(R.layout.item_label, null);
            TextView tvLabel = cvLabel.findViewById(R.id.tvLabel);
            tvLabel.setText(label.getName());
            cvLabel.setCardBackgroundColor(Color.parseColor("#" + label.getColor()));
            holder.addView(R.id.llLabels, cvLabel);
        }
    }

    @Override
    protected int getItemViewLayoutId(int viewType) {
        return R.layout.item_article;
    }
}