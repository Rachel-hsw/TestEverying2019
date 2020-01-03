package com.rachel.socketdemo_pigchatroom;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static Context get() {
        return instance;
    }
}
