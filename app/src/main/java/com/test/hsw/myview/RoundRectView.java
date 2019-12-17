package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class RoundRectView extends View {
    private final Paint mPaint;

    public RoundRectView(Context context) {
        this(context, null);
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(0xFF000000);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());

        canvas.drawRoundRect(rectF, getHeight() / 2, getHeight() / 2, mPaint);

    }
}
