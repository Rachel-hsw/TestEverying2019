package com.test.hsw;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

public class HandlerActivity1 extends Activity {
    //创建一个2M大小的int数组
    int[] datas = new int[1024 * 1024 * 2];
//    Handler mHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//        }


    /**
     * 创建静态内部类
     */
    private static class MyHandler extends Handler {
        //持有弱引用HandlerActivity,GC回收时会被回收掉.
        private final WeakReference<HandlerActivity1> mActivty;

        public MyHandler(HandlerActivity1 activity) {
            mActivty = new WeakReference<HandlerActivity1>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity1 activity = mActivty.get();
            super.handleMessage(msg);
            if (activity != null) {
                //执行业务逻辑
                Log.i("rachel","----------------------handleMessage");
            }
        }
    }

    private  static final Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            //执行我们的业务逻辑
            Log.i("rachel","----------------------run");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("rachel","----------------------main");
        MyHandler myHandler = new MyHandler(this);
        //解决了内存泄漏,延迟5分钟后发送
        myHandler.postDelayed(myRunnable, 1000 * 60 * 5);
    }
}
