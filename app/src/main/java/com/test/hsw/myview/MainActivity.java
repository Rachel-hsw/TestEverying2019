package com.test.hsw.myview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.test.hsw.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);
        LinearLayout ll = findViewById(R.id.ll);
        MyLinearLayout myLinearLayout = new MyLinearLayout(this);
        ll.addView(myLinearLayout);
    }
}
