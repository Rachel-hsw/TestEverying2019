package com.test.hsw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.hsw.myview.MyActivity;
import com.test.hsw.recyclerview.RecycleViewActivity;
import com.test.hsw.事件分发.EventDispatcherActivity;

public class MainActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void goMyActivity(View view) {
        startActivity(new Intent(MainActivity.this, MyActivity.class));

    }

    public void goEventDispatcherActivity(View view) {
        startActivity(new Intent(MainActivity.this, EventDispatcherActivity.class));
    }

    public void goRecycleViewActivity(View view) {
        startActivity(new Intent(MainActivity.this, RecycleViewActivity.class));
    }
}
