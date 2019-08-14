package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;

public abstract class AbsAnno extends PduBase
{
  private long timestamp;

  public abstract boolean contain(float paramFloat1, float paramFloat2);

  public abstract void draw(Canvas paramCanvas, Matrix paramMatrix);

  public abstract long getBlockhandle();

  public abstract long getFilehandle();

  public abstract long getId();

  public long getTimestamp()
  {
    return this.timestamp;
  }

  public void resetAnno(AbsAnno paramAbsAnno)
  {
  }

  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable)
  {
  }

  public abstract void setBlockhandle(long paramLong);

  public void setColor(int paramInt)
  {
  }

  public abstract void setFilehandle(long paramLong);

  public abstract void setId(long paramLong);

  public void setLinesize(short paramShort)
  {
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AbsAnno
 * JD-Core Version:    0.6.0
 */