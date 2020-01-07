package com.test.hsw.事件分发;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class 校长类 extends LinearLayout {
    private final static String tag = "rachel";

    public 校长类(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "校长类-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "校长类-dispatchTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "校长类-onInterceptTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "校长类-onInterceptTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "校长类-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "校长类-onTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return false;
    }


}
