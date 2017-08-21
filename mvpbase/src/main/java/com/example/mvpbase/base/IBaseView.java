package com.example.mvpbase.base;

import android.view.View;

/**
 * Created by shiji-xc on 2017/8/14.
 */

public interface IBaseView{

    /**
     * 首次进入页面显示SwipeRefreshLayout
     */
    void showLoading();

    /**
     * 首次加载完成取消SwipeRefreshLayout
     */
    void dismissLoading();

    /**
     * 设置标题栏
     */
    void setTitle(String title);

    /**
     * 设置标题栏和状态栏颜色
     */
    void setColor(int ResColor);
}
