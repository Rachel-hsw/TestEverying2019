package com.test.hsw.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.hsw.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian_activity);
        焦点抢夺();
        SpannableString的使用();
        去阴影界面();
    }

    private void 去阴影界面() {
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShadowActivity.startShadowActivity(MainActivity.this);
            }
        });
    }

    /**
     * 可以好好研究一下
     */
    private void SpannableString的使用() {
        TextView test_text = findViewById(R.id.test_text);
        SpannableString spannableString = new SpannableString("京东 德国AEA保温壶家用暖壶水壶热水瓶暖瓶2L");
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
//        spannableString.setSpan(colorSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

//        BackgroundColorSpan colorSpan1 = new BackgroundColorSpan(Color.parseColor("#AC00FF30"));
//        spannableString.setSpan(colorSpan1, 0,2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

//        //居中对齐
        spannableString.setSpan(new VerticalCenterSpan(24), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        Drawable drawable = getResources().getDrawable(R.drawable.bg_yellow_4);
//        drawable.setBounds(0, 0, 42, 42);
//        ImageSpan imageSpan2 = new ImageSpan(drawable);
//        spannableString.setSpan(imageSpan2, 0, 2, ImageSpan.ALIGN_BASELINE);
//        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//        drawable.setBounds(0, 0, 42, 42);
//
//        //普通imageSpan 做对比
//        ImageSpan imageSpan2 = new ImageSpan(drawable);
//        spannableString.setSpan(imageSpan2, 3, 4, ImageSpan.ALIGN_BASELINE);
//        //居中对齐imageSpan
//        CenterAlignImageSpan imageSpan = new CenterAlignImageSpan(drawable);
//        spannableString.setSpan(imageSpan, 0, 1, ImageSpan.ALIGN_BASELINE);
//
//
//        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//        drawable.setBounds(0, 0, 42, 42);
//        ImageSpan imageSpan = new ImageSpan(drawable);
//        spannableString.setSpan(imageSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(0.5f);
//        spannableString.setSpan(sizeSpan01, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        test_text.setText(spannableString);
    }

    private void 焦点抢夺() {
        Button button = new Button(this);
        button.setText("终止");
        button.setTextSize(44);
        button.setBackgroundColor(0xFF569493);
        button.setTextColor(Color.WHITE);
        //主要是这个设置起了作用
        button.setClickable(true);
        RelativeLayout layout = findViewById(R.id.test);
        layout.addView(button);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "你点击了黄色区域", Toast.LENGTH_SHORT).show();
            }
        });
    }
}