package com.test.hsw.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.test.hsw.R;


public class PorterDuffXfermodeView extends View {

    private Paint paint;
    private Bitmap bitmap;
    private int currentTop;
    private RectF rectF;
    private PorterDuffXfermode xfermode;

    public PorterDuffXfermodeView(Context context) {
        super(context);
        init();
    }

    public PorterDuffXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_HARDWARE, null);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        //设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setDither(true);
        //加快显示速度，本设置项依赖于dither和xfermode的设置
        paint.setFilterBitmap(true);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        currentTop = bitmap.getHeight();
        rectF = new RectF(0, currentTop, bitmap.getWidth(), bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF.top = currentTop;

        canvas.drawBitmap(bitmap, 0, 0, null);
        paint.setXfermode(xfermode);
        paint.setColor(Color.RED);
        canvas.drawRect(rectF, paint);
        paint.setXfermode(null);

        if (currentTop > 0) {
            currentTop--;
            invalidate();
        }
    }
}

