package com.test.hsw.myview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.test.hsw.R;

public class MyActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int i;

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
        progressBar = findViewById(R.id.dd);
        progressBar.setProcess(0.01f);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProcess(i / 100f);
                        }
                    });
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
