package com.test.hsw.事件分发;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class 学生类 extends Button {
    private final static String tag = "rachel";

    public 学生类(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "学生类-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "学生类-onTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "学生类-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "学生类-dispatchTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }
}
