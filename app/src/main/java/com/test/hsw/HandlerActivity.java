package com.test.hsw;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class HandlerActivity extends Activity {

    //创建一个2M大小的int数组
    int[] datas = new int[1024 * 1024 * 2];
    static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.i("Rachel","------------");
            super.handleMessage(msg);
        }
    };

    private  static final Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            //执行我们的业务逻辑
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //解决了内存泄漏,延迟5分钟后发送
        mHandler.postDelayed(myRunnable,1000 * 60 * 5);
    }
}
