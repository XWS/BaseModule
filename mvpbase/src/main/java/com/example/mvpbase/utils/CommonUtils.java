package com.example.mvpbase.utils;

import android.content.res.Resources;

import com.example.mvpbase.App;

/**
 * Created by shiji-xc on 2017/8/10.
 */

public class CommonUtils {

    public static int getColor(int Res){
        return getResoure().getColor(Res);
    }

    public static Resources getResoure() {
        return App.getmInstance().getResources();
    }
}
