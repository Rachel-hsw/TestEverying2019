package com.gensee.pdu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

public class AnnoPointerEx extends AnnoPointer
{
  public static final short ANNO_POINTER_ARROW = 1;
  public static final short ANNO_POINTER_HAND;
  private static BitmapDrawable pointerCircleDrawable;
  private static BitmapDrawable pointerCrossDrawable;
  private byte pointerType;

  public AnnoPointerEx()
  {
    setType(9);
    this.pointerType = 1;
  }

  private void drawCrossDrawable(Canvas paramCanvas, Matrix paramMatrix, BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable == null)
    {
      super.draw(paramCanvas, paramMatrix);
      return;
    }
    Bitmap localBitmap = paramBitmapDrawable.getBitmap();
    if (localBitmap == null)
    {
      super.draw(paramCanvas, paramMatrix);
      return;
    }
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    long l1 = ()((float)getX() * arrayOfFloat[0] + arrayOfFloat[2]);
    long l2 = ()((float)getY() * arrayOfFloat[4] + arrayOfFloat[5]);
    paramCanvas.drawBitmap(localBitmap, (float)l1, (float)l2, new Paint());
  }

  private void drawDrawable(Canvas paramCanvas, Matrix paramMatrix, BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable == null)
    {
      super.draw(paramCanvas, paramMatrix);
      return;
    }
    Bitmap localBitmap = paramBitmapDrawable.getBitmap();
    if (localBitmap == null)
    {
      super.draw(paramCanvas, paramMatrix);
      return;
    }
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    long l1 = ()((float)getX() * arrayOfFloat[0] + arrayOfFloat[2]);
    long l2 = ()((float)getY() * arrayOfFloat[4] + arrayOfFloat[5]);
    paramCanvas.drawBitmap(localBitmap, (float)(l1 - localBitmap.getWidth() / 2), (float)(l2 - localBitmap.getHeight() / 2), new Paint());
  }

  public static BitmapDrawable getPointerCircleDrawable()
  {
    return pointerCircleDrawable;
  }

  public static BitmapDrawable getPointerCrossDrawable()
  {
    return pointerCrossDrawable;
  }

  public static void setPointerCircleDrawable(BitmapDrawable paramBitmapDrawable)
  {
    pointerCircleDrawable = paramBitmapDrawable;
  }

  public static void setPointerCrossDrawable(BitmapDrawable paramBitmapDrawable)
  {
    pointerCrossDrawable = paramBitmapDrawable;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    if (this.pointerType == 0)
    {
      drawDrawable(paramCanvas, paramMatrix, pointerCircleDrawable);
      return;
    }
    drawCrossDrawable(paramCanvas, paramMatrix, pointerCrossDrawable);
  }

  public byte getPointerType()
  {
    return this.pointerType;
  }

  public void setPointerType(byte paramByte)
  {
    this.pointerType = paramByte;
  }

  public String toString()
  {
    return "AnnoPointerEx [pointerType=" + this.pointerType + " " + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoPointerEx
 * JD-Core Version:    0.6.0
 */