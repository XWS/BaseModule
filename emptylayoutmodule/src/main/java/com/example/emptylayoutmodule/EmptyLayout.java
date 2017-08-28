package com.example.emptylayoutmodule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by shiji-xc on 2017/8/23.
 */

public class EmptyLayout extends FrameLayout {

    private Context context;
    public static final int STATUS_HIDE = 1001;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NO_NET = 2;
    public static final int STATUS_NO_DATA = 3;
    private int mEmptyStatus = STATUS_LOADING;
    private int color;
    private ProgressBar lodingView;
    private TextView net_error;

    public EmptyLayout(Context context) {
        this(context, null);
    }

    public EmptyLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EmptyLayout);
        try {
            color = typedArray.getColor(R.styleable.EmptyLayout_background_color, Color.WHITE);
        } finally {
            typedArray.recycle();
        }

        View view = inflate(context, R.layout.layout_empty_loading, this);
        view.findViewById(R.id.empty_layout).setBackgroundColor(color);
        lodingView = view.findViewById(R.id.empty_loading);
        net_error = view.findViewById(R.id.tv_net_error);
        switchLayout();
    }

    private void switchLayout() {
        switch (mEmptyStatus) {
            case STATUS_LOADING:
                setVisibility(VISIBLE);
                lodingView.setVisibility(VISIBLE);
                net_error.setVisibility(GONE);
                break;
            case STATUS_NO_NET:
                setVisibility(VISIBLE);
                lodingView.setVisibility(GONE);
                net_error.setVisibility(VISIBLE);
                break;
            case STATUS_NO_DATA:
                break;
            case STATUS_HIDE:
                setVisibility(GONE);
                break;
            default:
                break;
        }
    }

    /**
     * 隐藏视图
     */
    public void hide() {
        mEmptyStatus = STATUS_HIDE;
        switchLayout();
    }

    /**
     * 设置状态
     *
     * @param emptyStatus
     */
    public void setEmptyStatus(@EmptyStatus int emptyStatus) {
        mEmptyStatus = emptyStatus;
        switchLayout();
    }

    /**
     * 获取状态
     * @return  状态
     */
    public int getEmptyStatus() {
        return mEmptyStatus;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATUS_LOADING, STATUS_NO_NET, STATUS_NO_DATA})
    public @interface EmptyStatus{}
}
