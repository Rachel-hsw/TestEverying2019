package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleView2 extends View {
    private final Paint mPaint;

    public CircleView2(Context context) {
        this(context, null);
    }

    public CircleView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
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
        //这时的坐标轴为正,保存
        canvas.save();
        int progressBarLength = 34;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0x4DFF0000);
        canvas.drawCircle(getHeight() / 2f, getHeight() / 2f, getHeight() / 2f, mPaint);

        RectF oval = new RectF(0, 0, getHeight(), getHeight());
        double angle = Math.toDegrees(Math.acos((getHeight() / 2f - progressBarLength) / (getHeight() / 2f)));
        mPaint.setColor(0x4D0000FF);
        canvas.drawArc(oval, (float) (90 + (90 - angle)), (float) (2f * angle), false, mPaint);
        //中途进行了旋转，那么坐标轴的朝向发生改变
        canvas.translate(-(getHeight() / 2f - progressBarLength), 0);
        mPaint.setColor(0xFF00FF00);
        canvas.drawArc(oval, -90, 180, true, mPaint);
        //恢复画布，坐标轴为正
        canvas.restore();
        mPaint.setColor(0xFF000000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
        canvas.drawPoint(getHeight() / 2f, getHeight() / 2f, mPaint);

    }
}
