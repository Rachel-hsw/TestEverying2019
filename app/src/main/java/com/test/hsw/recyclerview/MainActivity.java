package com.test.hsw.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.hsw.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 老子以后写代码，一行代码一条注释。还附带简介，哼哼
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView contentRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentRv = findViewById(R.id.content_rv);
        //造了9条假数据，假装自己是个正了八经的九宫格
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            strings.add("");
        }
        //设置RecyclerView的布局管理器，这里我给的是一个三列，垂直方向上滑动的布局
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        contentRv.setLayoutManager(layoutManager);
        //这个就是我说的自定义边距，查看MarginDecoration这个类我具体给的配置
        contentRv.addItemDecoration(new MarginDecoration());
        //设置RecyclerView的适配器，并传入数据。目的是，每个子项的数据和布局的绑定
        contentRv.setAdapter(new RvAdapter(strings));

        //添加默认分割线：高度为2px，颜色为灰色
        contentRv.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL));
        //添加自定义分割线：可自定义分割线drawable
        contentRv.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.HORIZONTAL, R.drawable.ic_launcher_background));
        //添加自定义分割线：可自定义分割线高度和颜色
        contentRv.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.HORIZONTAL, 10, Color.BLUE));
    }
}
