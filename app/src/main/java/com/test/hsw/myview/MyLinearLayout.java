package com.test.hsw.myview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.hsw.R;

public class MyLinearLayout extends LinearLayout {

    private TextView footTv;

    public MyLinearLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setWillNotDraw(false);
        resize();
        addFooter();
    }

    /**
     * 根据节的数量重设宽度
     */
    private void resize() {
        LayoutParams lp = (LayoutParams) getLayoutParams();
        if (lp == null)
            lp = new LayoutParams(-2, -2);
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        setLayoutParams(lp);
    }

    /**
     * 创建段的底部
     */
    private void addFooter() {
        LayoutParams params = new LayoutParams(80, 30);
        footTv = new TextView(getContext());
        footTv.setId(R.id.stage_cycle_tv);
        Drawable drawableLeft = getContext().getDrawable(R.drawable.ic_cycle_b);
        footTv.setPadding(10, 0, 10, 0);
        footTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                null, null, null);
        footTv.setBackground(getContext().getDrawable(R.drawable.sel_blue_48));
        footTv.setGravity(Gravity.CENTER);
        footTv.setTextColor(0xFF0000FF);
        footTv.setText(2 + "x");
        footTv.setTextSize(18);
        footTv.setLayoutParams(params);

        LinearLayout layout = new LinearLayout(getContext());
        layout.setGravity(Gravity.CENTER);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
        lp.weight = 2;
        layout.addView(footTv);
        addView(layout, lp);

    }
}
