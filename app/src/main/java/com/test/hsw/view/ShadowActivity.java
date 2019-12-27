package com.test.hsw.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.test.hsw.R;


/**
 * @author Rachel
 */
public class ShadowActivity extends Activity {
    public static void startShadowActivity(Context context) {
        Intent intent = new Intent(context, ShadowActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
    }
}
