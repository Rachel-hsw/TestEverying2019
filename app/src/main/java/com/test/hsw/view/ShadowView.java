package com.test.hsw.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.test.hsw.R;


/**
 * 写得有问题
 */
public class ShadowView extends View {
    private final float cornerRadius;
    private final Paint mShadowPaint;
    private final int distance;

    public ShadowView(Context context) {
        this(context, null);
    }

    public ShadowView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShadowView);
        //设置阴影颜色
        int shadowColor = a.getColor(R.styleable.ShadowView_shadowColor, 0xffe1e5f0);
        //设置阴影的扩展距离
        distance = (int) a.getDimension(R.styleable.ShadowView_shadowDistance, 10);
        //设置子View背景的圆角大小
        cornerRadius = a.getDimension(R.styleable.ShadowView_shadowRadius, 10);
        //设置阴影向下移动距离
        float dx = a.getDimension(R.styleable.ShadowView_shadowDx, 0);
        //设置阴影在Y轴移动距离
        float dy = a.getDimension(R.styleable.ShadowView_shadowDy, 3);
        a.recycle();
        mShadowPaint = new Paint();
        mShadowPaint.setStyle(Paint.Style.FILL);
        mShadowPaint.setAntiAlias(true);
        mShadowPaint.setColor(Color.WHITE);
        mShadowPaint.setShadowLayer(distance, dx, dy, shadowColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (getLayerType() != LAYER_TYPE_SOFTWARE) {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
        int left = getLeft() + distance;
        int top = getTop() + distance;
        int right = getRight() - distance;
        int bottom = getBottom() - distance;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(left, top, right, bottom, cornerRadius, cornerRadius, mShadowPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
