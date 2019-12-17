package com.test.hsw.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.test.hsw.R;


public class ProgressBar extends View {
    private final static int Horizontal = 0;
    private final static int Vertical = 1;
    /**
     * 进度条当前值
     */
    private float percent;
    /**
     * 画笔
     */
    private Paint mPaint;
    private int mWidth, mHeight;
    private int backgroundColor;
    private int processColor;
    private int model;
    private RectF backRect;
    private RectF processRect;
    private PorterDuffXfermode mode;

    public ProgressBar(Context context) {
        this(context, null);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainStyledAttrs(attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        backRect = new RectF();
        processRect = new RectF();
        mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        setLayerType(LAYER_TYPE_HARDWARE, null);
    }

    private void obtainStyledAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ProgressBar);
        //背景
        backgroundColor = typedArray.getColor(R.styleable.ProgressBar_backgroundColor, 0xFFDFE2E9);
        //进度条
        processColor = typedArray.getColor(R.styleable.ProgressBar_processColor, 0xFF568BFF);
        model = typedArray.getInt(R.styleable.ProgressBar_model, 0);
        // 一定要回收
        typedArray.recycle();
    }

    /***
     * 设置当前的进度值
     * @param percent 进度百分比
     */
    public void setProcess(float percent) {
        this.percent = percent > 1 ? 1 : percent;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.reset();
        //设置抗锯齿效果
        mPaint.setAntiAlias(true);
        float value;
        //设置进度条长度
        float progressBarLength;
        if (model == Vertical) {
            value = mWidth / 2f;
            progressBarLength = mHeight * percent;
            processRect.right = mWidth;
            processRect.bottom = progressBarLength;
            //画布以进度条中心点旋转180度（垂直逆向）
            canvas.rotate(180, mWidth / 2f, mHeight / 2f);
        } else {
            value = mHeight / 2f;
            progressBarLength = mWidth * percent;
            processRect.right = progressBarLength;
            processRect.bottom = mHeight;
        }
        //绘制圆角矩形，背景色为画笔颜色
        //设置画笔颜色
        mPaint.setColor(backgroundColor);
        backRect.right = mWidth;
        backRect.bottom = mHeight;
        canvas.drawRoundRect(backRect, value, value, mPaint);
        //绘制进度条
        //设置画笔颜色
        if (percent != 0.0f) {
            mPaint.setColor(processColor);
        } else {
            mPaint.setColor(Color.TRANSPARENT);
        }
        if (progressBarLength > 2 * value) {
            canvas.drawRoundRect(processRect, value, value, mPaint);
        } else {
            if (model == Vertical) {
                canvas.translate(0, progressBarLength);
                //取两层绘制交集。显示上层
                mPaint.setXfermode(mode);
                canvas.drawCircle(value, -value, value, mPaint);
            } else {
                canvas.translate(progressBarLength, 0);
                //取两层绘制交集。显示上层
                mPaint.setXfermode(mode);
                canvas.drawCircle(-value, value, value, mPaint);
            }
        }
    }

    public static float dp2px(Context context, float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics()) + 0.5f;
    }

    //dip * scale + 0.5f * (dip >= 0 ? 1 : -1)
    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));//加0.5是为了四舍五入
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        //MeasureSpec.EXACTLY，精确尺寸
        if (widthSpecMode == MeasureSpec.EXACTLY || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
        } else {
            mWidth = 0;
        }

        //MeasureSpec.AT_MOST，最大尺寸，只要不超过父控件允许的最大尺寸即可，MeasureSpec.UNSPECIFIED未指定尺寸
        if (heightSpecMode == MeasureSpec.AT_MOST || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = dipToPx(20);
        } else {
            mHeight = heightSpecSize;
        }

        //设置控件实际大小
        setMeasuredDimension(mWidth, mHeight);
    }
}