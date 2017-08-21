package com.example.mvpbase.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mvpbase.R;
import com.example.mvpbase.utils.StatusBarUtil;

/**
 * Created by shiji-xc on 2017/8/14.
 */

public abstract class BaseActivity<T extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    private T mPresenter;
    private View baseView;
    private View currentView;
    private android.support.v7.widget.Toolbar toolbar;
    private TextView titleView;
    private SwipeRefreshLayout swipeRefresh;
    private int ResColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        baseView = LayoutInflater.from(this).inflate(R.layout.base_activity, null, false);
        currentView = LayoutInflater.from(this).inflate(layoutResID, null, false);

        swipeRefresh = baseView.findViewById(R.id.swipeRefresh);
        titleView = baseView.findViewById(R.id.title);
        toolbar = baseView.findViewById(R.id.toolBar);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        currentView.setLayoutParams(layoutParams);
        FrameLayout container = baseView.findViewById(R.id.container);
        container.addView(currentView);

        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorAccent));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);
        currentView.setVisibility(View.GONE);

        getWindow().setContentView(baseView);

        showLoading();
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        if(swipeRefresh!=null&&swipeRefresh.isRefreshing()){
            swipeRefresh.setRefreshing(false);
            swipeRefresh.setEnabled(false);
        }
    }

    @Override
    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void setColor(int ResColor) {
        this.ResColor = ResColor;
    }
}
