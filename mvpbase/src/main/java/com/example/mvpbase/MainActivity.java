package com.example.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mvpbase.base.BaseActivity;
import com.example.mvpbase.base.IBasePresenter;

public class MainActivity extends BaseActivity<IBasePresenter> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}