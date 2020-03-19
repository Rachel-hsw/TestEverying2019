package com.test.hsw.AtomicBoolean;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Created by PC on 2018/4/28.
 * AtomicBoolean 如果当前状态值等于预期值，则以原子方式将同步状态设置为给定的更新值。
 */
public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = new Thread(new TestAtomicBoolean("张三" + i));
            thread.start();
        }
    }

}


