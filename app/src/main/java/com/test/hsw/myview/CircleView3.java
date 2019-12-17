package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 当时想着用扇形去做，真是蠢透了
 */
public class CircleView3 extends View {
    private final Paint mPaint;

    public CircleView3(Context context) {
        this(context, null);
    }

    public CircleView3(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    /**
     * https://blog.csdn.net/iteye_5085/article/details/82648028 讲解save和restore方法
     * https://blog.csdn.net/tianjian4592/article/details/45234419 讲解translate、scale、rotate、skew方法
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int progressBarLength = 34;
        //绘制背景
        mPaint.setColor(0xFF000000);
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rectF, getHeight() / 2, getHeight() / 2, mPaint);
        RectF oval = new RectF(0, 0, getHeight(), getHeight());
        //绘制进度
        double angle = Math.toDegrees(Math.acos((getHeight() / 2f - progressBarLength) / (getHeight() / 2f)));
        mPaint.setColor(0xFF0000FF);
        canvas.drawArc(oval, (float) (90 + (90 - angle)), (float) (2f * angle), false, mPaint);
        //绘制半圆
        //中途进行了旋转，那么坐标轴的朝向发生改变
        canvas.translate(-(getHeight() / 2f - progressBarLength), 0);
        mPaint.setColor(0xFF00FF00);
        //取两层绘制交集。显示上层
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawArc(oval, -90, 180, true, mPaint);

    }
}
