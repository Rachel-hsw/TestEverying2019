package com.gensee.vodpdu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import com.gensee.common.GenseeConfig;
import com.gensee.utils.GenseeLog;

public class AnnoPointerEx extends AnnoPointer
{
  public static final short ANNO_POINTER_ARROW = 1;
  public static final short ANNO_POINTER_HAND;
  private short pointerType = 1;

  public AnnoPointerEx()
  {
    setType(2057);
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    if (this.pointerType == 0)
    {
      super.draw(paramCanvas, paramMatrix);
      return;
    }
    BitmapDrawable localBitmapDrawable = GenseeConfig.getArrowDrawable();
    if (localBitmapDrawable != null)
    {
      Bitmap localBitmap = localBitmapDrawable.getBitmap();
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      long l1 = ()((float)getX() * arrayOfFloat[0] + arrayOfFloat[2]);
      long l2 = ()((float)getY() * arrayOfFloat[4] + arrayOfFloat[5]);
      paramCanvas.drawBitmap(localBitmap, (float)(l1 - localBitmap.getWidth() / 2), (float)(l2 - localBitmap.getHeight() / 2), new Paint());
      return;
    }
    GenseeLog.w("this pointer is arrow ,but the arrowDrawable is not config ,so render the circle!");
    super.draw(paramCanvas, paramMatrix);
  }

  public short getPointerType()
  {
    return this.pointerType;
  }

  public void setPointerType(short paramShort)
  {
    this.pointerType = paramShort;
  }

  public String toString()
  {
    return "AnnoPointerEx [pointerType=" + this.pointerType + " " + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoPointerEx
 * JD-Core Version:    0.6.0
 */