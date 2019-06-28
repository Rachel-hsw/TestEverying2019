package com.test.hsw;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MarginDecoration extends RecyclerView.ItemDecoration {
    private int space;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //将所有子项的上边距设置为20
        outRect.top = 20;
        if (parent.getChildLayoutPosition(view) % 3 == 0) {
            //第一部分，position位置取余3等于0的（一共三列数据，即靠左边那列，设置其左边距为20）
            outRect.left = 20;
        } else if (parent.getChildLayoutPosition(view) % 3 == 2) {
            //第二部分，position位置取余3等于2的（一共三列数据，即靠右边那列，设置其右边距为20）
            outRect.right = 20;
        } else {
            //第三部分，position位置取余3等于1的（一共三列数据，即中间那列，设置其左右两边距皆为10）
            outRect.left = 10;
            outRect.right = 10;
        }
        //这样就保证了每一个子项与其他子项间距皆为10，就很均匀了。如果你要改变整体左边距和右边距就改第一和第二部分的值就可以了。如果是想更改子项与子项之间的间距，就改第三部分
    }
}
