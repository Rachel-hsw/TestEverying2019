package com.rachel.getwifissidandpassword;

import android.app.Application;

/**
 * @author Rachel
 */
public class WifiApplication extends Application {
    private static WifiApplication instance;

    public static WifiApplication get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
