package com.example.shiji_xc.basemodule.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.shiji_xc.basemodule.R;
import com.example.shiji_xc.basemodule.commondao.CommonViewDao;
import com.example.shiji_xc.basemodule.databinding.BaseActivityBinding;
import com.example.shiji_xc.basemodule.utils.CommonUtils;
import com.example.shiji_xc.basemodule.utils.StatusBarUtil;

/**
 * Created by shiji-xc on 2017/8/10.
 * BaseActivity
 */

public class BaseActivity<SV extends ViewDataBinding> extends AppCompatActivity implements View.OnClickListener {

    BaseActivityBinding basebinding;
    SV viewBinding;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {

        basebinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.base_activity, null, false);
        viewBinding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutResID, null, false);

        StatusBarUtil.setColor(this, CommonUtils.getColor(R.color.colorAccent));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        viewBinding.getRoot().setLayoutParams(params);
        basebinding.container.addView(viewBinding.getRoot());
        getWindow().setContentView(basebinding.getRoot());

        animationDrawable= (AnimationDrawable) basebinding.imgProgress.getDrawable();
        if(!animationDrawable.isRunning()){
            animationDrawable.start();
        }

        viewBinding.getRoot().setVisibility(View.GONE);
    }

    protected void setTitle(String title){
        basebinding.toolBar.setTitle(title);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
