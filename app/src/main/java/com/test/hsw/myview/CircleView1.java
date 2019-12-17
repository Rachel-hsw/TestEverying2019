package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleView1 extends View {
    private final Paint mPaint;
    Bitmap mSrcBitmap, mDstBitmap;
    Canvas mSrcCanvas, mDstCanvas;

    public CircleView1(Context context) {
        this(context, null);
    }

    public CircleView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView1(Context context, AttributeSet attrs, int defStyleAttr) {
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

        canvas.translate(-(getHeight() / 2f - progressBarLength), 0);
        mPaint.setColor(0xFF00FF00);
        //取两层绘制交集。显示上层
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawCircle(getHeight() / 2f, getHeight() / 2f, getHeight() / 2f, mPaint);

    }
}
