package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {
    //    private final Paint mPaint;
    Bitmap mSrcBitmap, mDstBitmap;
    Canvas mSrcCanvas, mDstCanvas;
    Paint mDstPaint, mSrcPaint;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
        mDstPaint = new Paint();
        mSrcPaint = new Paint();
        mDstPaint.setAntiAlias(true);
        mSrcPaint.setAntiAlias(true);
        mDstPaint.setColor(0x4DFFFFFF);
//        mDstPaint.setColor(Color.YELLOW);
        mSrcPaint.setColor(0xFFFFFFFF);
        setLayerType(LAYER_TYPE_HARDWARE, null);
        //准备画布
        mSrcBitmap = Bitmap.createBitmap(800, 400, Bitmap.Config.ARGB_8888);
        mSrcCanvas = new Canvas(mSrcBitmap);
        mDstBitmap = Bitmap.createBitmap(800, 400, Bitmap.Config.ARGB_8888);
        mDstCanvas = new Canvas(mDstBitmap);
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

        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        mDstCanvas.drawRoundRect(rectF, getHeight() / 2, getHeight() / 2, mDstPaint);

        mSrcCanvas.translate(-(getHeight() / 2f - progressBarLength), 0);

        mSrcCanvas.drawCircle(getHeight() / 2f, getHeight() / 2f, getHeight() / 2f, mSrcPaint);

        //准备好两张位图后在设置画笔模式，然后将图片画上去
        //取下层非交集部分与上层交集部分（后画上去的为上层，即显示在上面的为上层）
        mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
//        mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
//        mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(mDstBitmap, 0, 0, mDstPaint);
        canvas.drawBitmap(mSrcBitmap, 0, 0, mSrcPaint);
    }
}
