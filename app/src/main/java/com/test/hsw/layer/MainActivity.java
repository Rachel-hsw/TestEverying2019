package com.test.hsw.layer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.test.hsw.R;

/**
 * Android Canvas的save(),saveLayer()和restore()浅谈
 * https://www.cnblogs.com/liangstudyhome/p/4143498.html
 * Canvas 在一般的情况下可以看作是一张画布，所有的绘图操作如drawBitmap, drawCircle都发生在这张画布上，
 * 这张画板还定义了一些属性比如Matrix，颜色等等。但是如果需要实现一些相对复杂的绘图操作，
 * 比如多层动 画，地图（地图可以有多个地图层叠加而成，比如：政区层，道路层，兴趣点层）。
 * Canvas提供了图层（Layer）支持，缺省情况可以看作是只有一个图 层Layer。
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SampleView(this));
    }

    private static class SampleView extends View {
        private static final int LAYER_FLAGS = Canvas.ALL_SAVE_FLAG;

        private Paint mPaint;
        private ImageView imageView;

        public SampleView(Context context) {
            super(context);
            setFocusable(true);
            imageView = new ImageView(context);
            imageView.setId(R.id.img);

            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.translate(10, 10);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(75, 75, 75, mPaint);
            canvas.saveLayerAlpha(0, 0, 200, 200, 0x88, LAYER_FLAGS);
            mPaint.setColor(Color.BLUE);
            canvas.drawCircle(125, 125, 75, mPaint);
            canvas.restore();
        }
    }
}