package com.test.hsw.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.test.hsw.R;
import com.test.hsw.utils.SizeUtils;


public class DashboardProgressView extends View {
    private PaintFlagsDrawFilter mDrawFilter; // 为画布设置抗锯齿
    private float mOneRingWidth;//一环宽度
    private float mTwoRingWidth;//二环宽度
    private float mPadding; // 边距
    private float mScaleStrokeWidth; // 时刻笔触大小
    private float mScaleLineWidth;//时刻长度
    private float mTextSize;//文字大小

    private int mScaleColor;//刻度颜色
    private int mTextColor;//文字

    private int width; // 钟表的边长
    private Paint mPaint; // 画笔
    private String temperature = "";//当前温度
    private String time = "0";//已经运行时间
    private String state = "未开始";//运行状态
    private String sectionProgress = "0/0";//阶段进度
    private float timeProgress;//时间进度

    /**
     * @param attrs
     */
    private void obtainStyledAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DashboardProgressView);
        mOneRingWidth = typedArray.getDimension(R.styleable.DashboardProgressView_oneRingWidth, Dp2Px(30));
        mTwoRingWidth = typedArray.getDimension(R.styleable.DashboardProgressView_twoRingWidth, Dp2Px(10));
        mScaleLineWidth = typedArray.getDimension(R.styleable.DashboardProgressView_scaleLineWidth, Dp2Px(30));
        mScaleStrokeWidth = typedArray.getDimension(R.styleable.DashboardProgressView_scaleStrokeWidth, Dp2Px(5));
        mPadding = typedArray.getDimension(R.styleable.DashboardProgressView_padding, Dp2Px(10));
        mTextSize = typedArray.getDimension(R.styleable.DashboardProgressView_textSize, Sp2Px(14));

        mScaleColor = typedArray.getColor(R.styleable.DashboardProgressView_scaleColor, 0xFFA5A9FE);
        mTextColor = typedArray.getColor(R.styleable.DashboardProgressView_textColor, Color.GRAY);
        // 一定要回收
        typedArray.recycle();
    }

    public DashboardProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DashboardProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 获取属性
        obtainStyledAttrs(attrs);
        //初始化画笔
        initPaint();
        // 为画布实现抗锯齿（边缘柔化）
        mDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);

        //测量手机的宽度
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;

        // 默认和屏幕的宽高最小值相等
        width = Math.min(widthPixels, heightPixels);
    }


    public DashboardProgressView(Context context) {
        super(context);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int i = measureSize(widthMeasureSpec);
        int j = measureSize(heightMeasureSpec);
        setMeasuredDimension(i, j);
    }

    // 测量宽高和屏幕作对比
    private int measureSize(int measureSpec) {
        int size = MeasureSpec.getSize(measureSpec);
        width = Math.min(width, size);
        return width;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(mDrawFilter);
        // 绘制半径圆
        drawCircle(canvas);
        //绘制圆环
        drawCircleRing(canvas);
        // 绘制刻度尺
        printScale(canvas);
        //绘制文字
        drawText(canvas);
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSectionProgress(String sectionProgress) {
        this.sectionProgress = sectionProgress;
    }


    public void setTimeProgress(float timeProgress) {
        this.timeProgress = timeProgress;
    }

    private void drawCircleRing(Canvas canvas) {
        mPaint.setColor(0xFFEDF3FD);
        mPaint.setStrokeWidth(mOneRingWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 2, width / 2, width / 2 - mOneRingWidth / 2, mPaint);
        mPaint.setColor(0xFFD5E2F8);
        mPaint.setStrokeWidth(mTwoRingWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 2, width / 2, width / 2 - mOneRingWidth - mTwoRingWidth / 2, mPaint);
    }

    private void drawText(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(mTextSize);
        mPaint.setStrokeWidth(1.0f);
        mPaint.setColor(mTextColor);
        mPaint.setStyle(Paint.Style.FILL);


        Rect bounds2 = new Rect();
        mPaint.getTextBounds(time, 0, time.length(), bounds2);
        canvas.drawText(time, width / 2 - bounds2.width() / 2,
                width / 2 + bounds2.height() / 2, mPaint);
        RectF r2 = new RectF();
        mPaint.setStyle(Paint.Style.STROKE);
        r2.left = width / 2 - bounds2.width() / 2 - 30;
        r2.top = width / 2 - bounds2.height() / 2 - 10;
        r2.right = width / 2 + bounds2.width() / 2 + 30;
        r2.bottom = width / 2 + bounds2.height() / 2 + 10;
        canvas.drawRoundRect(r2, 45, 45, mPaint);


        int padding = 20;//行间距
        Rect bounds1 = new Rect();
        mPaint.getTextBounds(temperature, 0, temperature.length(), bounds1);
        canvas.drawText(temperature, width / 2 - bounds1.width() / 2,
                width / 2 - bounds2.height() / 2 - 10 - padding, mPaint);

        Rect bounds3 = new Rect();
        mPaint.getTextBounds(state, 0, state.length(), bounds3);

        canvas.drawText(state, width / 2 - bounds3.width() / 2,
                width / 2 + bounds2.height() / 2 + padding + bounds3.height(), mPaint);
        Rect bounds4 = new Rect();
        mPaint.getTextBounds(sectionProgress, 0, sectionProgress.length(), bounds4);

        canvas.drawText(sectionProgress, width / 2 - bounds4.width() / 2,
                width / 2 + bounds2.height() / 2 + padding + bounds3.height() + padding + bounds4.height(), mPaint);
    }

    private void printScale(Canvas canvas) {
        mPaint.setStrokeWidth(SizeUtils.Dp2Px(getContext(), 1));

        for (int i = 0; i < 100; i++) {
            if (i >= timeProgress) {
                mPaint.setColor(0xFFDADEDA);
            } else {
                mPaint.setColor(mScaleColor);
            }
            mPaint.setStrokeWidth(SizeUtils.Dp2Px(getContext(), mScaleStrokeWidth));
            canvas.drawLine(width / 2, mOneRingWidth + mTwoRingWidth + mPadding, width / 2, mOneRingWidth + mTwoRingWidth + mPadding + mScaleLineWidth, mPaint);
            canvas.rotate((float) 3.6, width / 2, width / 2);
        }
    }

    private void drawCircle(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width / 2, width / 2, width / 2, mPaint);
    }

    private float Sp2Px(int value) {
        return SizeUtils.Sp2Px(getContext(), value);
    }

    private float Dp2Px(int value) {
        return SizeUtils.Dp2Px(getContext(), value);
    }
}
