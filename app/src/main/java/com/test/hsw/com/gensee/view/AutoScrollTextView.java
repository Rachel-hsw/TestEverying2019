package com.gensee.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.TextView;

public class AutoScrollTextView extends TextView
{
  private boolean bLeft = false;
  private Paint paint = null;
  private String text = "";
  private float textLength = 0.0F;
  private float tx = 0.0F;
  private float ty = 0.0F;

  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void initScrollTextView(WindowManager paramWindowManager, String paramString)
  {
    this.paint = getPaint();
    this.text = paramString;
    this.textLength = this.paint.measureText(paramString);
    this.ty = (getTextSize() + getPaddingTop());
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawText(this.text, this.tx, this.ty, this.paint);
    int i = (int)(this.textLength - getWidth());
    if (i > 0)
    {
      if (this.bLeft)
        break label85;
      this.tx = (float)(this.tx - 0.6D);
      if (Math.abs(this.tx) >= i)
        this.bLeft = true;
    }
    while (true)
    {
      invalidate();
      super.onDraw(paramCanvas);
      return;
      label85: this.tx = (float)(0.6D + this.tx);
      if (this.tx < 0.0F)
        continue;
      this.bLeft = false;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.AutoScrollTextView
 * JD-Core Version:    0.6.0
 */