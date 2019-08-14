package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.zhy.android.percent.support.PercentRelativeLayout;

public class IrregularPercentRelativeLayout extends PercentRelativeLayout
{
  private int a = -1;
  private int b = -1;
  private Bitmap c;

  public IrregularPercentRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }

  public IrregularPercentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public IrregularPercentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (paramMotionEvent.getAction() != 0)
        return super.onTouchEvent(paramMotionEvent);
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((this.a == -1) || (this.b == -1))
      {
        this.c = ((BitmapDrawable)getBackground().getCurrent()).getBitmap();
        this.a = getWidth();
        this.b = getHeight();
      }
      if ((this.c == null) || (i < 0) || (j < 0) || (i >= this.a) || (j >= this.b) || (i >= this.c.getWidth()) || (j >= this.c.getHeight()))
        break label160;
      int k = this.c.getPixel(i, j);
      if (k == 0)
        return false;
    }
    catch (Exception localException)
    {
    }
    return super.onTouchEvent(paramMotionEvent);
    label160: return false;
  }

  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.IrregularPercentRelativeLayout
 * JD-Core Version:    0.6.0
 */