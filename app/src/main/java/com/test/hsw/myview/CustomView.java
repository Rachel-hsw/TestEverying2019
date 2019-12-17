package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * https://blog.csdn.net/u013135085/article/details/81186375
 * PorterDuff.Mode
 */
public class CustomView extends View {

    Paint mDstPaint, mSrcPaint;
    Bitmap mSrcBitmap, mDstBitmap;
    Canvas mSrcCanvas, mDstCanvas;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDstPaint = new Paint();
        mSrcPaint = new Paint();
        mDstPaint.setColor(0x4D0000FF);
        mDstPaint.setAntiAlias(true);
//        mSrcPaint.setColor(Color.YELLOW);
        mSrcPaint.setColor(Color.BLUE);
        mSrcPaint.setAntiAlias(true);
        //开启硬件离屏缓存：解决黑色问题，效率比关闭硬件加速高。暂时没有发现其他影响
        setLayerType(LAYER_TYPE_HARDWARE, null);

        //准备画布
        mSrcBitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
        mSrcCanvas = new Canvas(mSrcBitmap);
        mDstBitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
        mDstCanvas = new Canvas(mDstBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //dst
        mDstCanvas.drawRect(50, 50, 150, 150, mDstPaint);
        mSrcCanvas.drawCircle(50, 50, 50, mSrcPaint);

        //准备好两张位图后在设置画笔模式，然后将图片画上去
        mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(mDstBitmap, 0, 0, mDstPaint);
        canvas.drawBitmap(mSrcBitmap, 0, 0, mSrcPaint);
    }
}