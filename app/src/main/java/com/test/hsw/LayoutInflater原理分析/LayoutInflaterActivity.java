package com.test.hsw.LayoutInflater原理分析;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.test.hsw.R;

/**
 * 准备学习自定义View，先从布局加载开始
 * 这个大佬让我终于明白了什么叫做inflate参数
 * 三个案例带你看懂LayoutInflater中inflate方法两个参数和三个参数的区别
 * 郭神也讲得很浅显易懂
 * Android LayoutInflater原理分析，带你一步步深入了解View(一)
 * ————————————————
 * 版权声明：本文为CSDN博主「哑巴湖小水怪」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/changhuzichangchang/article/details/88659870
 */
public class LayoutInflaterActivity extends AppCompatActivity {
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        mainLayout = findViewById(R.id.main_layout);
        //只有3会不符合期望
//        addChildView1();
        addChildView2();
//        addChildView3();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutInflaterActivity.this, "你点击到我了", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 不添加到root布局下，但是会辅助button_layout的根节点生成布局参数
     */
    private void addChildView1() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View buttonLayout = layoutInflater.inflate(R.layout.button_layout, mainLayout, false);
        mainLayout.addView(buttonLayout);
    }

    /**
     * 添加到root布局下，且会辅助button_layout的根节点生成布局参数
     */
    private void addChildView2() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        layoutInflater.inflate(R.layout.button_layout, mainLayout, true);
    }

    /**
     * root为null的情况下，attachToRoot值不影响，button_layout的根节点失效
     */
    private void addChildView3() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View buttonLayout = layoutInflater.inflate(R.layout.button_layout, null);
        mainLayout.addView(buttonLayout);
    }
}
