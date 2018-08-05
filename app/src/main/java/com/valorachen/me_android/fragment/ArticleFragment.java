package com.valorachen.me_android.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.chenyuwei.basematerial.fragment.BaseRecyclerViewFragment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.valorachen.me_android.adapter.ArticleAdapter;
import com.valorachen.me_android.http.RequestMaker;
import com.valorachen.me_android.http.ServiceFactory;
import com.valorachen.me_android.model.Issue;

import java.util.List;

/**
 * Created by vivi on 2016/7/18.
 */
public class ArticleFragment extends BaseRecyclerViewFragment<Issue,ArticleAdapter> {

    @Override
    protected void onCreateView() {
        super.onCreateView();
        setPullRefreshEnable(true);
        setPullLoadEnable(true);
        new RequestMaker<List<Issue>>(activity, ServiceFactory.getIssueService().get(1)){
            @Override
            protected void onSuccess(List<Issue> issues) {
                data.addAll(issues);
                notifyDataSetChanged();
            }
        };
    }

    @Override
    protected RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(activity);
    }

    @Override
    protected ArticleAdapter setAdapter() {
        return new ArticleAdapter(activity,data);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        stopRefresh();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshlayout) {
        super.onLoadMore(refreshlayout);
        stopLoadMore();
    }
}
