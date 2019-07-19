package com.test.hsw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * https://www.cnblogs.com/liangstudyhome/p/4143498.html
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