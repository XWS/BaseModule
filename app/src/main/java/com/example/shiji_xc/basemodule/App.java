package com.example.shiji_xc.basemodule;

import android.app.Application;

/**
 * Created by shiji-xc on 2017/8/10.
 */

public class App extends Application {

    private static App mInstance;

    public static App getmInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
