package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TestView extends View {

    private final Paint paint;
    private final Paint bgPaint;

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        bgPaint = new Paint();
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setColor(Color.BLACK);
        bgPaint.setStrokeWidth(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth() - 1, getHeight() - 1, bgPaint);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(20);
        paint.setColor(Color.BLUE);
        //顶部居中绘制一个圆
        canvas.drawCircle(getWidth() / 2, 20, 20, paint);
        //右上角绘制一个圆
        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() - 20, 20, 20, paint);
    }
}
