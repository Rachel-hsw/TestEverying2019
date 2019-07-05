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

public class CircleProgressView1 extends View {
    float progress = 0;
    private String text = "0%";
    private int max = 100;
    private String chronometer;

    public CircleProgressView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleProgressView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView1(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.progress = 50;
        this.text = "当前温度" + 65 + "°C";
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        float width = getMeasuredWidth();
        float strokeBg = 15;
        float radiusBg = width / 2;
        paint.setStrokeWidth(strokeBg);
        paint.setColor(0x66DBDBDB);//灰色
        canvas.drawCircle(radiusBg, radiusBg, radiusBg - strokeBg / 2, paint);

        float strokeBlue = 10;
        float margin = 15;
        float radiusBlue = radiusBg - margin;
        paint.setStrokeWidth(strokeBlue);
        paint.setColor(0xFF3866AB);//蓝色
        //真正圆的落笔处在这个正方形上
        RectF oval = new RectF(margin, margin, width - margin, width - margin);
        canvas.drawArc(oval, -90, 360 * progress / max, false, paint);

        float radiusCircle = strokeBlue/2;
        paint.setStyle(Style.FILL);
        paint.setColor(0xFF3866AB);
        canvas.drawCircle(radiusBg,margin , radiusCircle, paint);
        canvas.drawCircle((float) (radiusBg + radiusBlue * Math.sin(360 * progress / max * Math.PI / 180)), (float) (radiusBg - radiusBlue * Math.cos(360 * progress / max * Math.PI / 180)), radiusCircle, paint);


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
