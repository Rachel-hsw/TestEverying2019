package com.gensee.pdu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

public class AnnoFreepenEx extends AnnoFreepen
{
  public static final int STEP_ADD = 2;
  public static final int STEP_BEGIN = 1;
  public static final int STEP_COMPLETE = 0;
  public static final int STEP_END = 3;
  private static BitmapDrawable freepenExDrawable;
  private AnnoFPoint lastPoint;
  private int stepType;

  public AnnoFreepenEx()
  {
    setType(16);
  }

  public static BitmapDrawable getFreepenExDrawable()
  {
    return freepenExDrawable;
  }

  public static void setFreepenExDrawable(BitmapDrawable paramBitmapDrawable)
  {
    freepenExDrawable = paramBitmapDrawable;
  }

  public boolean appendEX(AnnoFreepenEx paramAnnoFreepenEx)
  {
    if (paramAnnoFreepenEx == null)
      return false;
    int i = paramAnnoFreepenEx.getStepType();
    setStepType(i);
    AnnoFPoint[] arrayOfAnnoFPoint = paramAnnoFreepenEx.getPoints();
    if (2 == i)
    {
      appendPoints(arrayOfAnnoFPoint);
      AnnoFPoint localAnnoFPoint = null;
      if (arrayOfAnnoFPoint != null)
      {
        int j = arrayOfAnnoFPoint.length;
        localAnnoFPoint = null;
        if (j > 0)
          localAnnoFPoint = arrayOfAnnoFPoint[(-1 + arrayOfAnnoFPoint.length)];
      }
      this.lastPoint = localAnnoFPoint;
    }
    while (true)
    {
      return true;
      if (3 == i)
      {
        appendPoints(paramAnnoFreepenEx.getPoints());
        this.lastPoint = null;
        continue;
      }
      if ((1 == i) || (i != 0))
        continue;
      clearPoints();
      appendPoints(arrayOfAnnoFPoint);
      this.lastPoint = null;
    }
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    super.draw(paramCanvas, paramMatrix);
    if ((getStepType() != 0) && (3 != getStepType()) && (freepenExDrawable != null) && (this.lastPoint != null))
    {
      Bitmap localBitmap = freepenExDrawable.getBitmap();
      if (localBitmap != null)
      {
        float[] arrayOfFloat = new float[9];
        paramMatrix.getValues(arrayOfFloat);
        long l1 = ()(this.lastPoint.x * arrayOfFloat[0] + arrayOfFloat[2]);
        long l2 = ()(this.lastPoint.y * arrayOfFloat[4] + arrayOfFloat[5]);
        paramCanvas.drawBitmap(localBitmap, (float)l1, (float)l2, new Paint());
      }
    }
  }

  public int getStepType()
  {
    return this.stepType;
  }

  protected void setPoints(AnnoFPoint[] paramArrayOfAnnoFPoint)
  {
    if ((paramArrayOfAnnoFPoint != null) && (paramArrayOfAnnoFPoint.length > 0))
    {
      super.setPoints(paramArrayOfAnnoFPoint);
      this.lastPoint = paramArrayOfAnnoFPoint[(-1 + paramArrayOfAnnoFPoint.length)];
    }
  }

  public void setStepType(int paramInt)
  {
    this.stepType = paramInt;
  }

  public String toString()
  {
    return "AnnoFreepenEx [stepType=" + this.stepType + ", " + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoFreepenEx
 * JD-Core Version:    0.6.0
 */