package com.example.shiji_xc.basemodule.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.shiji_xc.basemodule.R;
import com.example.shiji_xc.basemodule.base.BaseActivity;
import com.example.shiji_xc.basemodule.databinding.Activity1Binding;

/**
 * Created by shiji-xc on 2017/8/7.
 */

public class Activity1 extends BaseActivity<Activity1Binding> {

    private Activity1Binding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        setTitle("赵桓真帅");
    }
}
