package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressView extends View {
    float progress = 0;
    private String text = "0%";
    private int max = 100;
    private String chronometer;

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        int stroke = 10;//笔触，是最小圆半径的两倍
        int minRadius = stroke / 2;
        float width = getMeasuredWidth();
        float radius = (width - minRadius * 4) / 2;//最大圆的半径
        paint.setStrokeWidth(stroke);
        paint.setColor(0xFFDBDBDB);//灰色
        canvas.drawCircle(radius + 2 * minRadius, radius + 2 * minRadius, radius, paint);

        paint.setStrokeWidth(stroke);
        RectF oval = new RectF(2 * minRadius, 2 * minRadius, radius * 2 + 2 * minRadius, radius * 2 + 2 * minRadius);
        paint.setColor(0xFF4080F4);//蓝色
        canvas.drawArc(oval, -90, 360 * progress / max, false, paint);

        paint.setStrokeWidth(stroke);
        paint.setStyle(Style.FILL);
        paint.setColor(0xFFD3623E);//姜黄
        RectF point = new RectF(radius + minRadius, minRadius, radius + 3 * minRadius, 3 * minRadius);
        canvas.drawArc(point, 0, 360, true, paint);//画一个点
        paint.setStrokeWidth(2 * stroke);
        paint.setColor(0xFFEDBC40);//明黄
        canvas.drawCircle((float) (radius + 2 * minRadius + radius * Math.sin(360 * progress / max * Math.PI / 180)), (float) (radius + 2 * minRadius - radius * Math.cos(360 * progress / max * Math.PI / 180)), stroke, paint);

        paint.setStyle(Style.STROKE);
        paint.setTextSize(14);
        paint.setStrokeWidth(1.0f);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        paint.setColor(Color.GRAY);
        paint.setStyle(Style.FILL);
        canvas.drawText(text, width / 2 - bounds.width() / 2,
                width / 2 + bounds.height() / 2, paint);

        int padding = 10;
        Rect bounds1 = new Rect();
        paint.getTextBounds(chronometer, 0, chronometer.length(), bounds1);

        canvas.drawText(chronometer, width / 2 - bounds1.width() / 2,
                width / 2 + bounds.height() / 2 + bounds1.height() + padding, paint);
    }

    /**
     * 初始设置当前进度的最大值-默认100
     *
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * 更新进度和文字
     *
     * @param progress
     * @param temp
     * @param chronometer
     */
    public void setProgressAndText(float progress, float temp, String chronometer) {
        this.progress = progress;
        this.text = "当前温度" + temp + "°C";
        this.chronometer = chronometer;
        if (progress > max) {
            return;
        }
        postInvalidate();
    }

}
