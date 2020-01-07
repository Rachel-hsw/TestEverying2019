package com.test.hsw.事件分发;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.test.hsw.R;


public class EventDispatcherActivity extends Activity {
    private final static String tag = "rachel";
    学生类 学生;
    校长类 校长;
    private 老师类 老师;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dispatcher);
        学生 = (学生类) findViewById(R.id.btn_test);
        学生.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(tag, "学生---onClick...");
            }
        });
        学生.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(tag, "学生-onTouch-ACTION_DOWN...");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(tag, "学生-onTouch-ACTION_UP...");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        老师 = (老师类) findViewById(R.id.center);
        老师.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(tag, "老师---onClick...");
            }
        });
        老师.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(tag, "老师-onTouch-ACTION_DOWN...");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(tag, "老师-onTouch-ACTION_UP...");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        校长 = (校长类) findViewById(R.id.linearlayout_test);
        校长.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(tag, "校长-onTouch-ACTION_DOWN...");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(tag, "校长-onTouch-ACTION_UP...");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        校长.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(tag, "校长---onClick...");
            }
        });
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "EventDispatcherActivity-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "EventDispatcherActivity-dispatchTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "EventDispatcherActivity-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "EventDispatcherActivity-onTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }


}
