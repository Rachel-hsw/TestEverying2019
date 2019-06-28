package com.test.hsw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contentRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentRv = findViewById(R.id.content_rv);
        //造了20条假数据
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("");
        }
        //设置RecyclerView的布局管理器，这里我给的是一个三列，垂直方向上滑动的布局
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        contentRv.setLayoutManager(layoutManager);
        //这个就是我说的自定义边距
        contentRv.addItemDecoration(new MarginDecoration());
        //设置RecyclerView的适配器，并传入数据。目的是，每个子项的数据和布局的绑定
        contentRv.setAdapter(new RvAdapter(strings));
    }
}
